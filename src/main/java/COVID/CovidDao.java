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

    public void registerPatient(String citizen_name, int zip, int age, String email, String ssn) {

        try (Connection conn = getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into citizens (citizen_name, zip, age, email, ssn, number_of_vaccination) values (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, citizen_name);
            stmt.setInt(2, zip);
            stmt.setInt(3, age);
            stmt.setString(4, email);
            stmt.setString(5, ssn);
            stmt.setInt(6, 0);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public void registerPatient(Connection conn, String citizen_name, int zip, int age, String email, String ssn) {
        try (PreparedStatement stmt = conn.prepareStatement("insert into citizens (citizen_name, zip, age, email, ssn, number_of_vaccination) values (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, citizen_name);
            stmt.setInt(2, zip);
            stmt.setInt(3, age);
            stmt.setString(4, email);
            stmt.setString(5, ssn);
            stmt.setInt(6, 0);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

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
                         " where zip = ? and status < 2 and (status = 0 or (ABS(DATEDIFF(current_timestamp,vac.vaccination_date )) >= 15)) \n" +
                         " order by age, citizen_name\n" +
                         " limit 16;")) {
                stmt.setInt(1, postCode);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        for (int i = 0; i < 5; i++) {
                            int j = i - 1;
                            if (j == -1) {
                                writer.write(startTime.plusMinutes(30).toString() + ";");
                                j++;
                            }
                            writer.write((rs.getString(Headers.values()[j].name())) + ((j == 5) ? ";\n" : ";"));
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
}


















































