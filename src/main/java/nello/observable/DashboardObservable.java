package nello.observable;

import nello.observer.DashboardObserver;

public interface DashboardObservable {
    /**
     * notify all observers
     */
    void notifyObservers();

    /**
     * register observers and notify them on registration.
     *
     * @param observer {@link DashboardObserver} loginObserver
     */
    void registerObserver(DashboardObserver observer);
}
