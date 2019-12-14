package server.model;

import server.persistance.User.UserDAO;
import shared.User;

public class ModelImp implements Model {
    private UserDAO user;

    public ModelImp(UserDAO user ) {
        this.user = user;
    }

    @Override
    public User login(String username, String password) {
        user.getUserWithLogin(username, password);
        return null;
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
