package server.databasestuff;

import server.PropertyChangeSubject;
import server.databasestuff.DatabaseConnection;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginDAO implements PropertyChangeSubject {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public LoginDAO(DatabaseConnection database) {
    }

    public void checkLogin(String s, String s1) {
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
