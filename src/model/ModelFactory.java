package model;

public class ModelFactory {

    private LoginModel loginModel;

    public LoginModel getLoginModel() {
        if(loginModel == null)
            loginModel = new LoginModelImp();
        return loginModel;
    }
}
