package model.login;

import model.login.LoginModel;
import networking.login.LoginClient;

public class LoginModelImp implements LoginModel {
    private LoginClient client;
    private String username;
    private String password;
    private String serverResponse;

    public LoginModelImp(LoginClient loginClient) {
        this.client = loginClient;
    }

    @Override
    public void loginStatus(String response) {
        serverResponse = response;
    }

    public void login(String username, String password) {
        client.Login(username,password);
    }

    @Override
    public String getServerResponse() {
        return serverResponse;
    }
}
