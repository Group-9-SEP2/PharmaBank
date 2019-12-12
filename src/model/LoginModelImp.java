package model;
import networking.login.LoginClientImp;
public class LoginModelImp implements LoginModel{
    private LoginClient client;
    private String username;
    private String password;
    private String serverResponse;

    public LoginModelImp(){
    }


    @Override
    public void login(String username, String password) {
        client.login(username,password);
    }

    @Override
    public String getServerResponse() {
        return serverResponse;
    }

    public void loginStatus(String status) {
        serverResponse = status;
    }
}
