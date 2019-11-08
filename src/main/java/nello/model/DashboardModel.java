package nello.model;

import nello.observable.DashboardObservable;
import nello.observer.DashboardObserver;

import java.util.List;

public class DashboardModel implements DashboardObservable {
    /**
     * observers list.
     */
    private List<DashboardObserver> observerList;

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
