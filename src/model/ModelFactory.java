package model;

import Networking.ClientFactory;

public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;

    public LoginModel getLoginModel() {
        if(loginModel == null)
            loginModel = new LoginModelImp();
        return loginModel;
    }
}
