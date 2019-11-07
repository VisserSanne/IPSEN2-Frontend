package nello.model;

import nello.observable.UsersTabObservable;
import nello.observer.UsersTabObserver;

import java.util.ArrayList;
import java.util.List;

public class UsersTabModel implements UsersTabObservable {
    private User user;
    private List<UsersTabObserver> observerList;

    public UsersTabModel() {
        observerList = new ArrayList<>();
        this.user = null;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void registerObserver(UsersTabObserver o) {

    }

    @Override
    public void notifyObservers() {

    }
}
