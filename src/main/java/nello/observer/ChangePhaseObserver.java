package nello.observer;

import nello.observable.ChangePhaseObservable;

public interface ChangePhaseObserver {

    void update(ChangePhaseObservable observable);
}
