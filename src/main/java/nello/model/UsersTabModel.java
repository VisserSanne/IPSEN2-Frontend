package nello.model;

import nello.observable.UsersTabObservable;
import nello.observer.UsersTabObserver;

import java.util.ArrayList;
import java.util.List;

public class UsersTabModel implements UsersTabObservable {
    private User user;
    private List<UsersTabObserver> observerList;
    private String message;

    public UsersTabModel() {
        observerList = new ArrayList<>();
        this.user = null;
        this.message = "";
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    @Override
    public void registerObserver(UsersTabObserver o) {
        if (o != null) {
            observerList.add(o);
            o.update(this);
        }

    }

    @Override
    public void notifyObservers() {
        for (UsersTabObserver o : observerList) {
            if (o != null){
                System.out.println(user.getId());
                o.update(this);
            }
        }

    }
}
