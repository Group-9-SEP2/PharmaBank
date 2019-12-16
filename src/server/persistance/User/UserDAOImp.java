package server.persistance.User;

import server.persistance.DatabaseConnection;
import server.persistance.User.UserDAO;
import shared.User;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAOImp implements UserDAO {
    private DatabaseConnection database;

    public UserDAOImp(DatabaseConnection database) {
        this.database = database;
    }


    @Override
    public void storeUser(User newUser) {
        //database.commandToDatabase("INSERT INTO User VALUES ('"+ newUser.getUsername() +"', '"+ newUser.getPassword() +"', '"+ newUser.getAccessLevel() +"', '"+ newUser.getBuildingNo() +"', '"+ newUser.getUserNo()+"');");
    }

    @Override
    public User getUser(String userNo) {
        //return database.commandToDatabase("SELECT * FROM User\n" + "WHERE userNo = '" + userNo+ "';");
        return null;
    }

    @Override
    public User getUserWithLogin(String username, String password) {
        /*
        set search_path = 'PharmaSystem';

        CREATE TABLE SystemUser
                (
                        username  varchar(25) NOT NULL,
                        password  varchar(25) UNIQUE NOT NULL,
                        accessLevel varchar(10),
                        buildingNo varchar(4),
                        userNo varchar(10)
                );

        Insert into SystemUser(username, password, accessLevel, buildingNo, userNo)
        VALUES ('admin', 'admin', 'admin', 'null', 'U001');

        Select * from SystemUser;

        
         */





        User userFromServer = null;

        try {
            database.getConnection().createStatement();
            ResultSet rs = database.getStatement().executeQuery(
                    "SELECT * FROM \"PharmaSystem\".SystemUser\n" +
                    "WHERE username = '" + username + "' AND password = '"+ password +"';"
            );


            String usernameDB = rs.getString("username");
            String passwordDB = rs.getString("password");
            String accessLevelDB = rs.getString("accessLevel");
            String buildingNoDB = rs.getString("buildingno");
            String userNoDB = rs.getString("userno");
            System.out.println("im in get user with login");
            userFromServer = new User(usernameDB, passwordDB, accessLevelDB, buildingNoDB, userNoDB);
            //TODO Make the response of the server visible in gui
            rs.close();
            database.getStatement().close();
            database.getConnection().close();

            return userFromServer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
