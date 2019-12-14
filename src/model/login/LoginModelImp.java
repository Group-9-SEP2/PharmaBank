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
    public void loginResponse(String response) {
        serverResponse = response;
        System.out.println(serverResponse + " after getting it form client");
    }

    public void login(String username, String password) {
        client.Login(username,password);

    }

    @Override
    public String getServerResponse() {
        return serverResponse;
    }
}
