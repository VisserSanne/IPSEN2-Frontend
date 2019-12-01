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
    private List<Team> teamsList;
    private List<NetworkMember> networkMemberList;

    public DashboardModel() {
        this.observerList = new ArrayList<>();
        this.experimentList = null;
        this.networkMemberList = null;
    }

    @Override
    public Experiment[] getExperimentList() {
        return experimentList;
    }

    @Override
    public List<Team> getTeamsList() {
        return teamsList;
    }

    @Override
    public List<NetworkMember> getNetworkMemberList() {
        return networkMemberList;
    }

    public void setExperimentList(Experiment[] experimentList) {
        this.experimentList = experimentList;
        notifyObservers();
    }

    public void setNetworkMembers(List<NetworkMember> networkMemberList) {
        this.networkMemberList = networkMemberList;
        notifyObservers();
    }

    public void setTeamList(List<Team> teamsList) {
        this.teamsList = teamsList;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (DashboardObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(DashboardObserver observer) {
        System.out.println(observer);
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }
}
