package model;

import networking.login.LoginClientImp;

public interface LoginModel {
    void setClient(LoginClientImp loginClientImp);

    void loginStatus(String status);
}
