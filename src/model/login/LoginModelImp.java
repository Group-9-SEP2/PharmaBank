package model.login;

import model.login.LoginModel;
import networking.login.LoginClient;
import shared.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginModelImp implements LoginModel{
    private LoginClient client;
    private String serverResponse;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LoginModelImp(LoginClient loginClient) {
        this.client = loginClient;
    }

    @Override
    public void loginResponse(String response) {
        serverResponse = response;
        System.out.println(serverResponse + " after getting it form client");
        support.firePropertyChange("ResponseUpdated", null, response);
    }

    public void login(String username, String password) {
        client.setModel(this);
        client.Login(username,password);
    }

    @Override
    public String getServerResponse() {
        return serverResponse;
    }




    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
