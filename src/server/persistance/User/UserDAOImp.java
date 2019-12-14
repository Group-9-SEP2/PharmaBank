package server.persistance.User;

import server.persistance.DatabaseConnection;
import server.persistance.User.UserDAO;
import shared.User;

public class UserDAOImp implements UserDAO {
    private DatabaseConnection database;

    public UserDAOImp(DatabaseConnection database) {
        this.database = database;
    }


    @Override
    public void storeUser(User newUser) {
        database.commandToDatabase("INSERT INTO User VALUES ('"+ newUser.getUsername() +"', '"+ newUser.getPassword +"', '"+ newUser.getAccesLevel() +"', '"+ newUser.getBuildingNo() +"', '"+ newUser.getUserNo()"');");
    }

    @Override
    public User getUser(String userNo) {
        return database.commandToDatabase(
                "SELECT * FROM User\n" +
                        "WHERE userNo = '" + userNo+ "';");
    }

    @Override
    public void getUserWithLogin(String usename, String password) {
        database.commandToDatabase(
                "SELECT * FROM User\n" +
                "WHERE username = '" + usename+ "' AND password = '"+ password +"';"
        );
    }
}
