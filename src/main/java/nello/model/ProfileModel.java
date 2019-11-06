package nello.model;

import nello.observable.ProfileObservable;
import nello.observer.ProfileObserver;

import java.util.ArrayList;
import java.util.List;

public class ProfileModel implements ProfileObservable {

    private User user;
    private List<ProfileObserver> observerList;

    public ProfileModel() {
        observerList = new ArrayList<>();
        this.user = null;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.notifyObservers();
    }

    @Override
    public void registerObserver(ProfileObserver o) {
        if (o != null) {
            observerList.add(o);
            o.update(this);
        }

    }

    @Override
    public void notifyObservers() {
        for (ProfileObserver o : observerList) {
            if (o != null){
                System.out.println(user.getEmail());
                o.update(this);
            }
        }

    }
}
