package nello.observable;

import nello.observer.LogObserver;

import java.time.LocalDateTime;

public interface LogObservable {

    long getExperimentId();
    String getStatus();
    String getPerson();
    LocalDateTime getCreateDateTime();

    void notifyObservers();

    void registerObserver(LogObserver logObserver);

}
