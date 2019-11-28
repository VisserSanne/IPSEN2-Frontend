package nello.model;

import nello.observable.DashboardObservable;
import nello.observer.DashboardObserver;

import java.util.ArrayList;
import java.util.List;

public class DashboardModel implements DashboardObservable {
    /**
     * observers list.
     */
    private List<DashboardObserver> observerList;
    private Experiment[] experimentList;
    private NetworkMember[] networkMembers;

    public DashboardModel() {
        this.observerList = new ArrayList<>();
        this.experimentList = null;
        this.networkMembers = null;
    }

    @Override
    public Experiment[] getExperimentList() {
        return experimentList;
    }

    @Override
    public NetworkMember[] getNetworkMemberList() {
        return networkMembers;
    }

    public void setExperimentList(Experiment[] experimentList) {
        this.experimentList = experimentList;
        notifyObservers();
    }

    public void setNetworkMembers(NetworkMember[] networkMembers) {
        this.networkMembers = networkMembers;
    }

    @Override
    public void notifyObservers() {
        for (DashboardObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(DashboardObserver observer) {
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }
}
