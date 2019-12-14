package server.persistance.User;

import shared.User;

public interface UserDAO {
    void storeUser(User newUser);

    User getUser(String userNo);
    void getUserWithLogin(String usename, String password);
}
