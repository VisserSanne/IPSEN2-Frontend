package nello.model;

import nello.observable.LogObservable;
import nello.observer.LogObserver;

import java.time.LocalDateTime;
import java.util.List;

public class Log implements LogObservable {

    private long experimentId;
    private String status;
    private String person;
    private LocalDateTime createDateTime;

    private List<LogObserver> observerList;

    public Log(long experimentId, String status, String person, LocalDateTime createDateTime) {
        this.experimentId = experimentId;
        this.status = status;
        this.person = person;
        this.createDateTime = createDateTime;
    }

    public long getExperimentId() {
        return experimentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerson() {
        return person;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public void notifyObservers() {
        for(LogObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(LogObserver logObserver) {
        observerList.add(logObserver);
        logObserver.update(this);
    }

}
