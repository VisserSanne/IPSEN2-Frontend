package nello.observable;

import nello.model.Credential;
import nello.model.LoginModel;
import nello.observer.LoginObserver;

public interface LoginObservable {

    LoginModel.Phase getCurrentPhase();

    String getMessage();

    Credential getCredentials();

    /**
     * notify all observers
     */
    void notifyObservers();

    /**
     * register observers and notify them on registration.
     *
     * @param observer {@link LoginObserver} loginObserver
     */
    void registerObserver(LoginObserver observer);
}
