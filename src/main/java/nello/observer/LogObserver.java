package nello.observer;

import nello.observable.LogObservable;

public interface LogObserver {

    void update(LogObservable logObservable);

}
