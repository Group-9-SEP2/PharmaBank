package database;

import database.DAO.UserDAO;
import model.Users;

import java.util.ArrayList;
import java.util.List;

public class UserDAOManager implements UserDAO {

    List<Users> users;

    public UserDAOManager() {
    users = new ArrayList<Users>();

    }

    @java.lang.Override
    public List<Users> getUsers() {
        return null;
    }

    @java.lang.Override
    public void updateUsers() {

    }

    @java.lang.Override
    public void deleteUsers() {

    }

    @java.lang.Override
    public void addUsers() {

    }
}
