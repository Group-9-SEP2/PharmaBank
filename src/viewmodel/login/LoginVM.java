package viewmodel.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.login.LoginModel;

import java.beans.PropertyChangeEvent;
public class LoginVM {
    private StringProperty username, password, loginReponse;
    private LoginModel model;

    public LoginVM(LoginModel loginModel) {
        this.model = loginModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginReponse = new SimpleStringProperty();
        //model.addPropertyChangeListener(EventType.LOGIN_RESULT.toString(), this::onLoginResponse);
    }



    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty loginReponseProperty() {
        return loginReponse;
    }

    public void login() {
        System.out.println(username.get());
        System.out.println(password.get());
        model.login(username.get(), password.get());
    }

    private void onLoginResponse(PropertyChangeEvent evt) {
        String result = (String) evt.getNewValue();
        loginReponse.set(result);
    }
}

