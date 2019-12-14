package server.model;

import server.persistance.User.UserDAO;
import shared.User;

public class ModelImp implements Model {
    private UserDAO userDAO;

    public ModelImp(UserDAO user ) {
        this.userDAO = user;
    }

    @Override
    public User login(String username, String password) {
        User userFromDB = userDAO.getUserWithLogin(username, password);
        System.out.println("returned from database");
        System.out.println(userFromDB);
        return userFromDB;
    }

    @Override
    public void createBuilding() {

    }

    @Override
    public void removeBuilding() {

    }

    @Override
    public void editBuilding() {

    }

    @Override
    public void createUser() {

    }

    @Override
    public void removeUser() {

    }
}
