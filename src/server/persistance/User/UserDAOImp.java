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
        User userFromServer = null;

        try {
            database.getConnection().createStatement();
            ResultSet rs = database.getStatement().executeQuery(
                    "SELECT * FROM User\n" +
                    "WHERE username = '" + username + "' AND password = '"+ password +"';"
            );


            String usernameDB = rs.getString("username");
            String passwordDB = rs.getString("password");
            String accessLevelDB = rs.getString("accessLevel");
            String buildingNoDB = rs.getString("buildingNo");
            String userNoDB = rs.getString("userNo");
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
