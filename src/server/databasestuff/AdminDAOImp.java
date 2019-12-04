package server.databasestuff;

import server.PropertyChangeSubject;
import shared.Admin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AdminDAOImp implements AdminDAO,PropertyChangeSubject {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public AdminDAOImp(DatabaseConnection database) {
    }

    @Override
    public boolean checkLogin(String username, String pasword) {
        return true;
    }

    @Override
    public Admin getUser() {
        return null;
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
