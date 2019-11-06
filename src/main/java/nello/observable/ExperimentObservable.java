package nello.observable;

import nello.model.Attachment;
import nello.model.Experiment;
import nello.model.Log;
import nello.observer.ExperimentObserver;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ExperimentObservable {

    long getId();
    Experiment.Category getCategory();
    Experiment.Phase getPhase();
    String getBusinessOwner();
    String getDescription();
    String getName();
    String getStatusColor();
    LocalDate getCreateDate();
    Date getEndDate();
    String getStatus();
    List<Log> getLogs();
    List<Attachment> getAttachments();
    boolean isLocked();

    /**
     * Notifies all registered observers that there has been an update
     *
     * @author Valerie Timmerman
     */

    void notifyObservers();

    void registerObserver(ExperimentObserver observer);

}
