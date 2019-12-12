package networking.login;

import model.LoginModel;
import networking.ClientSocketHandler;
import networking.login.LoginClient;

public class LoginClientImp implements LoginClient {
    private ClientSocketHandler socketHandler;
    private LoginModel model;
    private String response;

    public LoginClientImp(ClientSocketHandler csh){
        this.socketHandler = csh;
    }

    @Override
    public void Login(String username, String password) {
        String sending = "Login" + "|GAP|" + username + "|GAP|" + password;
        socketHandler.sendToServer(sending);
    }

    @Override
    public String loginSuccesStatus() {
        return null;
    }

    @Override
    public void loginResponse(String response) {
        this.response = response;
    }

    public void setResponse(String response){
        this.response = response;
    }


    @Override
    public void setModel(LoginModel model) {
        this.model = model;
    }
}
