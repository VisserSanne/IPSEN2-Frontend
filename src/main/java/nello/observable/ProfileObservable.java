package nello.observable;

import nello.model.User;
import nello.observer.ProfileObserver;

public interface ProfileObservable {

    User getUser();

    void registerObserver(ProfileObserver o);

    void notifyObservers();

}
