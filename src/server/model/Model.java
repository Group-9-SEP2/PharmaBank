package server.model;

import shared.User;

public interface Model {

    User login(String username, String password);
    void createBuilding();
    void removeBuilding();
    void editBuilding();
    void createUser();
    void removeUser();

}
