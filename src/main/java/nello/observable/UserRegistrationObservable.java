package nello.observable;

import nello.observer.UserRegistrationObserver;

import java.util.HashMap;

public interface UserRegistrationObservable {

    void registerObserver(UserRegistrationObserver o);

    void notifyObservers();

    HashMap<String, String> getErrorMessages();
}
