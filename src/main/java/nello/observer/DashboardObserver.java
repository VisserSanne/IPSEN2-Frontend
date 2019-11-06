package nello.observer;

import nello.observable.DashboardObservable;

public interface DashboardObserver {
    void update(DashboardObservable observable);

}
