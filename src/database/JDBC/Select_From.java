package database.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Select_From {


    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "1234");
            c.setAutoCommit(false);
            System.out.println("Opened database");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"pharmabank\".Building;");
            while (rs.next()) {
                String BuildingNo = rs.getString("BuildingNo");
                String Address = rs.getString("Address");
                String BuildingName = rs.getString("BuildingName");
                System.out.println("BuildingNo = " + BuildingNo);
                System.out.println("Address = " + Address);
                System.out.println("BuildingName = " + BuildingName);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database query ok ");
    }
}
