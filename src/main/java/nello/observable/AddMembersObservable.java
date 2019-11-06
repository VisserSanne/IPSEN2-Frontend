package nello.observable;

import nello.model.AddMembersModel;
import nello.observer.AddMembersObserver;

public interface AddMembersObservable {

    /**
     * notify all observers
     */
    void notifyObservers();

    /**
     * register observers and notify them on registration.
     *
     * @param observer {@link AddMembersObserver} loginObserver
     */
    void registerObserver(AddMembersObserver observer);
}
