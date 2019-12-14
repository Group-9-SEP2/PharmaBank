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
        database.commandToDatabase("INSERT INTO User VALUES ('"+ newUser.getUsername() +"', '"+ newUser.getPassword() +"', '"+ newUser.getAccessLevel() +"', '"+ newUser.getBuildingNo() +"', '"+ newUser.getUserNo()+"');");
    }

    @Override
    public User getUser(String userNo) {
        return database.commandToDatabase(
                "SELECT * FROM User\n" +
                        "WHERE userNo = '" + userNo+ "';");
    }

    @Override
    public void getUserWithLogin(String username, String password) {
        database.commandToDatabase(
                "SELECT * FROM User\n" +
                "WHERE username = '" + usename+ "' AND password = '"+ password +"';"
        );

        ArrayList<String> infoFromSelected = new ArrayList<>();
        try {
            database.getConnection().createStatement();
            ResultSet rs = database.getStatement().executeQuery(
                    "SELECT * FROM User\n" +
                    "WHERE username = '" + usename+ "' AND password = '"+ password +"';"
            );


            String usernameDB = rs.getString("username");
            String passwordDB = rs.getString("password");
            String accessLevelDB = rs.getString("accessLevel");
            String buildingNoDB = rs.getString("buildingNo");
            String userNoDB = rs.getString("userNo");

            User userFromServer = new User(usernameDB, passwordDB, accessLevelDB, buildingNoDB, userNoDB)

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
