package nello.observable;

import nello.model.Experiment;
import nello.model.NetworkMember;
import nello.model.Team;
import nello.observer.DashboardObserver;

import java.util.List;

public interface DashboardObservable {

    Experiment[] getExperimentList();
    List<Team> getTeamsList();
    List<NetworkMember> getNetworkMemberList();


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
