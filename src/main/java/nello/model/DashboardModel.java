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

    public DashboardModel() {
        this.observerList = new ArrayList<>();
        this.experimentList = null;
    }

    @Override
    public Experiment[] getExperimentList() {
        return experimentList;
    }

    public void setExperimentList(Experiment[] experimentList) {
        System.out.println("setting experiments");
        this.experimentList = experimentList;
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
        System.out.println("register observer");
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }
}
