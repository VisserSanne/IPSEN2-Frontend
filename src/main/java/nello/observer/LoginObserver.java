package nello.observer;

import nello.observable.LoginObservable;

public interface LoginObserver {

    void update(LoginObservable observable);
}
