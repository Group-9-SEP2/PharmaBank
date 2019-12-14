package networking.login;

import model.login.LoginModel;
import networking.ClientSocketHandler;

public class LoginClientImp implements LoginClient {
    private ClientSocketHandler socketHandler;
    private LoginModel model;
    private String response;

    public LoginClientImp(ClientSocketHandler csh){
        this.socketHandler = csh;
    }

    @Override
    public void Login(String username, String password) {
        String sending = "Login" + "/" + username + "/" + password;
        System.out.println(sending);
        socketHandler.sendToServer(sending);
    }

    @Override
    public String loginSuccesStatus() {
        return null;
    }

    @Override
    public void loginResponse(String response) {
        this.response = response;
        model.loginResponse(response);
    }

    @Override
    public void setModel(LoginModel model) {
        this.model = model;
    }
}
