package server.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnection {
    private Connection c;
    private Statement stmt;
    public DatabaseConnection() {
        c = null;
        stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:1234/postgres",
                            "postgres", "uogauoga123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            /*
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"PharmaSystem\".SystemUser;" );
            while ( rs.next() ) {
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");
                String accessLevelDB = rs.getString("accessLevel");
                String buildingNoDB = rs.getString("buildingno");
                String userNoDB = rs.getString("userno");

                System.out.println(usernameDB);
                System.out.println(passwordDB);
                System.out.println(accessLevelDB);
                System.out.println(buildingNoDB);
                System.out.println(userNoDB);

            }
            rs.close();
            stmt.close();
            c.close();

             */
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Database query ok ");
    }

    public Connection getConnection() {
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:1234/postgres",
                            "postgres", "uogauoga123");
            c.setAutoCommit(false);
        } catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return c;
    }

    public Statement getStatement() {
        return stmt;
    }

    public void setStatement(Statement statement) {
        stmt = statement;
    }
}
