package nello.observable;

import nello.observer.LoginObserver;
import nello.observer.TabObserver;

public interface TabObservable {

    String getActiveTab();

    /**
     * notify all observers
     */
    void notifyObservers();

    /**
     * register observers and notify them on registration.
     *
     * @param observer {@link LoginObserver} loginObserver
     */
    void registerObserver(TabObserver observer);
}
