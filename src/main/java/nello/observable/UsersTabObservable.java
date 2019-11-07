package nello.observable;

import nello.model.User;
import nello.observer.UsersTabObserver;

public interface UsersTabObservable {

    User getUser();

    void registerObserver(UsersTabObserver o);

    void notifyObservers();
}
