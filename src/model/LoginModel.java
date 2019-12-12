package model;

public interface LoginModel {
    void login(String username, String password);
    String getServerResponse();
}
