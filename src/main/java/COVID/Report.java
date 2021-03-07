package COVID;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Report {

    public void riport() {

        System.out.println("\n\n[6. Report]\nHere is the requested pivot table.");

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        try (Connection conn = new CovidDao().getDataSource().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select zip, number_of_vaccination, count(number_of_vaccination) from citizens" +
                     " group by number_of_vaccination, zip" +
                     " order by zip asc, count(number_of_vaccination) DESC;")) {
            printWriter.print("\nPostCode - Number of Vaccination - Aggregate Number of Vaccination");
            while (rs.next()) {
                printWriter.printf("\n%s\t\t\t\t%d\t\t\t\t\t\t\t\t%d", rs.getString("zip"), rs.getInt("number_of_vaccination"), rs.getInt("count(number_of_vaccination)"));
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by query", sqle);
        }
        System.out.println(stringWriter.toString());
    }
}
