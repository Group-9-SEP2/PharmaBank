package server.persistance;

import java.sql.*;
import java.util.ArrayList;

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
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Database query ok ");
    }

    public Connection getConnection() {
        return c;
    }

    public Statement getStatement() {
        return stmt;
    }
}
