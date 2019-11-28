package nello.observable;

import nello.model.Experiment;
import nello.model.NetworkMember;
import nello.observer.DashboardObserver;

public interface DashboardObservable {

    Experiment[] getExperimentList();
    NetworkMember[] getNetworkMemberList();

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
