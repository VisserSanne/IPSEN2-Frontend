package nello.observer;

import nello.observable.ExperimentObservable;

public interface ExperimentObserver {

    void update(ExperimentObservable experimentObservable);

}
