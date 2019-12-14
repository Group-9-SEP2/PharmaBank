package database.JDBC;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create_Building_Table {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/postgres","postgres", "1234");
                System.out.println("Database Connected");


                stmt = c.createStatement();
                // If you wanted to create a table here, this is how you would do it:
                String sql = "CREATE TABLE IF NOT EXISTS \"PharmaBank\".Building" +
                "(BuildingNo char(5)  primary key  NOT NULL," +
                "Address  varchar(40)  NOT NULL, " +
                "BuildingName varchar(20)    NOT NULL)";
                /* Do not want to make the whole database through jdbc, not a requirement plus
                * too tedious*/


                /*This is for reusing sql statements in the future, */
            String prepareSQL;
            prepareSQL = "INSERT INTO \"pharmabank\".Building (BuildingNo, Address, BuldingName) "+
                    + "SELECT * FROM (SELECT ?,?,?) AS tmp"
                    +"WHERE NOT EXISTS (SELECT BuildingNo FROM \"pharmabank\".Building"
                    +"WHERE BuildingNo = ?) LIMIT 1";

            PreparedStatement preparedStatement =null;
            try {
                preparedStatement = c.prepareStatement(prepareSQL);
            }catch (SQLException e){
                e.printStackTrace();
            }

            addBuildingToDatabase(preparedStatement, "F0001","Some street 123","Factory 1");
            addBuildingToDatabase(preparedStatement, "F0002","Some street 321","Factory 2");
            addBuildingToDatabase(preparedStatement, "D0001","Some street 132","DC 1");
            addBuildingToDatabase(preparedStatement, "D0002","Some street 312","DC 2");

            //Need to put this somewhere properly
            private  static  void  addBuildingToDatabase(PreparedStatement preparedStatement, String BuildingNo, String Address, String BuildingName){
                try{
                    preparedStatement.setString(1,BuildingNo);
                    preparedStatement.setString(2,Address);
                    preparedStatement.setString(3,BuildingName);
                    preparedStatement.executeUpdate();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            stmt.executeUpdate(sql);
                stmt.close();
                c.close();

        }catch (Exception e){
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
                }
                System.out.println("Oki doki");
    }
}
