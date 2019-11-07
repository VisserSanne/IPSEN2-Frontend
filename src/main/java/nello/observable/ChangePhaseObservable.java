package nello.observable;

import nello.observer.ChangePhaseObserver;

public interface ChangePhaseObservable {

    void notifyObservers();

    /**
     * register observers and notify them on registration.
     *
     * @param observer {@link ChangePhaseObserver} loginObserver
     */
    void registerObserver(ChangePhaseObserver observer);

}
