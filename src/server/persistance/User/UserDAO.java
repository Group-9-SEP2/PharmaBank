package server.persistance.User;

import shared.User;

public interface UserDAO {
    void storeUser(User newUser);

    User getUser(String userNo);
    User getUserWithLogin(String usename, String password);
}
