package nello.observer;

import nello.observable.UserRegistrationObservable;

public interface UserRegistrationObserver {

    void update(UserRegistrationObservable o);
}
