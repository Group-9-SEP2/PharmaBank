package viewmodel.login;

import javafx.application.Platform;
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
        model.addPropertyChangeListener("ResponseUpdated", this::onLoginResponse);
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
        if(username.get() != null && password.get() != null) {
            loginReponse.setValue(null);
            model.login(username.get(), password.get());
        }
        else{
            loginReponse.setValue("Must enter both, username and password");
            username.setValue(null);
            password.setValue(null);
        }
    }

    private void onLoginResponse(PropertyChangeEvent evt){
        System.out.println("in observer");
        String response = (String) evt.getNewValue();
        System.out.println((String) evt.getNewValue());
        System.out.println((String) evt.getOldValue());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                loginReponse.setValue(response);
            }
        });
    }
}

