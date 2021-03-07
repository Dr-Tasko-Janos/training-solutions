package COVID;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class CovidDao {

    public MariaDbDataSource getDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306:/covid?useUnicode=true");
            dataSource.setUser("covidUser");
            dataSource.setPassword("covidUser");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("DataSource create error", sqle);
        }
        return dataSource;
    }

    public String settlementFromPostcode(DataSource dataSource, int postCode) {
        String settlement = "unknown";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select settlement from postcode where code = ?")) {
            stmt.setInt(1, postCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    settlement = rs.getString("settlement");
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error caused by query", sqle);
        }
        return settlement;
    }

    public Boolean isSsnExists(DataSource dataSource, String ssn) {
        Boolean searchResult = false;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select ssn from citizens where ssn = ?")) {
            stmt.setString(1, ssn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("");
                    System.out.printf("\nTHE GIVEN SSN(%s) IS ALREADY EXISTS", ssn);
                    searchResult = true;
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error caused by query", sqle);
        }
        return searchResult;
    }


    ////////////////////////////////


    public void registerPatient(int citizen_id, String citizen_name, int zip, int age, String email, String ssn) {

        try (Connection conn1 = getDataSource().getConnection()) {

            conn1.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn1.prepareStatement("insert into citizens (citizen_id, citizen_name, zip, age, email, ssn, number_of_vaccination) values (?, ?, ?, ?, ?, ?, ?)")) {
                stmt1.setInt(1, citizen_id);
                stmt1.setString(2, citizen_name);
                stmt1.setInt(3, zip);
                stmt1.setInt(4, age);
                stmt1.setString(5, email);
                stmt1.setString(6, ssn);
                stmt1.setInt(7, 0);
                stmt1.executeUpdate();


                try (PreparedStatement stmt2 = conn1.prepareStatement("insert into vaccinations (citizen_id, status) values (?, ?)")) {
                    stmt2.setInt(1, citizen_id);
                    stmt2.setInt(2, 0);
                    stmt2.executeUpdate();
                    conn1.commit();
                }

            } catch (
                    SQLException sqle) {
                conn1.rollback();
                throw new IllegalArgumentException("Error by insert", sqle);
            }
            conn1.commit();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by set autocommit to false", sqle);
        }
    }


    ////////////////////////////////////////

    public void registerPatient(Connection conn, String citizen_name, int zip, int age, String email, String ssn) {
        try {
            conn.setAutoCommit(false);


            try (PreparedStatement stmt1 = conn.prepareStatement("insert into citizens (citizen_id, citizen_name, zip, age, email, ssn, number_of_vaccination) values (?, ?, ?, ?, ?, ?, ?)")) {
                CovidMain.citizen_id = CovidMain.citizen_id + 1;
                stmt1.setInt(1, CovidMain.citizen_id);
                stmt1.setString(2, citizen_name);
                stmt1.setInt(3, zip);
                stmt1.setInt(4, age);
                stmt1.setString(5, email);
                stmt1.setString(6, ssn);
                stmt1.setInt(7, 0);
                stmt1.executeUpdate();

                try (PreparedStatement stmt2 = conn.prepareStatement("insert into vaccinations (citizen_id, status) values (?, ?)")) {
                    stmt2.setInt(1, CovidMain.citizen_id);
                    stmt2.setInt(2, 0);
                    stmt2.executeUpdate();
                    conn.commit();
                }

            } catch (SQLException sqle) {
                conn.rollback();
                throw new IllegalArgumentException("Error by insert", sqle);
            }
            conn.commit();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by set autocommit to false", sqle);
        }
    }

    ////////////////////////////////////////

    public Set<String> queryPostCodesExists() {

        Set<String> zipSet = new HashSet<>();

        MariaDbDataSource dataSource = getDataSource();

        try (Connection conn = dataSource.getConnection()) {
            Statement stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select distinct(ssn) from citizens")) {
                while (rs.next()) {
                    zipSet.add(rs.getString("ssn"));
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error caused by query", sqle);
        }
        return zipSet;
    }

    public void queryForVaccinationByPosteCodeIntoFile(String fileName, int postCode) {
        LocalTime startTime = LocalTime.of(07, 30);

        Path file = Path.of(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {

            writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");

            MariaDbDataSource dataSource = getDataSource();

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(" select citizen_name, zip, age, email, ssn from citizens as cit\n" +
                         " inner join vaccinations as vac on cit.citizen_id = vac.citizen_id \n" +
                         " where zip = ? and status != 2 and number_of_vaccination < 2 and (number_of_vaccination = 0 or (ABS(DATEDIFF(current_timestamp,cit.last_vaccination )) >= 15)) \n" +
                         " order by age desc, citizen_name asc\n" +
                         " limit 16;")) {
                stmt.setInt(1, postCode);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        for (int i = 0; i < 5; i++) {
                            int j = i - 1;
                            if (j == -1) {
                                startTime = startTime.plusMinutes(30);
                                writer.write(startTime.toString() + ";");
                                //j++;
                            }
                            writer.write((rs.getString(Headers.values()[i].name())) + ((i == 4) ? ";\n" : ";"));
                        }
                    }
                } catch (SQLException sqle) {
                    throw new IllegalArgumentException("Error caused by ResultSet", sqle);
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by query", sqle);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File can not write", ioe);
        }
    }

    public int lastPatientIdFinder() {
        int lastPatientId = 0;

        MariaDbDataSource dataSource = getDataSource();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select max(citizen_id) from citizens")) {

            if (rs.next()) {
                lastPatientId = rs.getInt("max(citizen_id)");
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by query", sqle);
        }
        return lastPatientId;
    }


    public void vaccinationStatus(String ssn) {

        try (Connection conn = getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement("select citizen_name, number_of_vaccination, " +
                     "last_vaccination, vaccination_type, cit.citizen_id " +
                     "from citizens as cit " +
                     "inner join vaccinations as vac " +
                     "on cit.citizen_id = vac.citizen_id " +
                     "where ssn = ? ")) {
            stmt.setString(1, ssn);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String citizenName = rs.getString("citizen_name");
                    int numberOfVaccination = rs.getInt("number_of_vaccination");
                    Date lastVaccinationDate = rs.getDate("last_vaccination");
                    String vaccineType = rs.getString("vaccination_type");
                    int citizenId = rs.getInt("citizen_id");
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error caused by executeQuery", sqle);
            }
        } catch (
                SQLException sqle) {
            throw new IllegalArgumentException("Error cause by SQL Query", sqle);
        }
    }


    public void vaccinationUpdater(int updatedNumberOfVaccination, String vaccinationType, String ssn, int updatedVaccinationStatus, int citizenId) {

        try (Connection conn1 = getDataSource().getConnection()) {

            conn1.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn1.prepareStatement("update citizens set number_of_vaccination = ?, last_vaccination = current_timestamp where ssn = ?")) {
                stmt1.setInt(1, updatedNumberOfVaccination);
                stmt1.setString(2, ssn);

                stmt1.executeUpdate();


                try (PreparedStatement stmt2 = conn1.prepareStatement("update vaccinations set status = ?, vaccination_type = ? where citizen_id = ?")) {
                    stmt2.setInt(1, updatedVaccinationStatus);
                    stmt2.setString(2, vaccinationType);
                    stmt2.setInt(3, citizenId);
                    stmt2.executeUpdate();
                    conn1.commit();
                }

            } catch (
                    SQLException sqle) {
                conn1.rollback();
                throw new IllegalArgumentException("Error by insert", sqle);
            }
            conn1.commit();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by set autocommit to false", sqle);
        }
    }

    public boolean isAdequateTimeElapsed(String ssn) {
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement("select ssn from citizens where ssn = ? and (ABS(DATEDIFF(current_timestamp,last_vaccination )) >= 15)")) {
            stmt.setString(1, ssn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
                return false;
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by query", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by query", sqle);
        }
    }
}






























