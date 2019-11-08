package nello.observer;

import nello.observable.UsersTabObservable;

public interface UsersTabObserver {

    void update(UsersTabObservable o);
}
