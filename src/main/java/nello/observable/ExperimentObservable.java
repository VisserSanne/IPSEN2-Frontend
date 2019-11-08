package nello.observable;

import nello.model.Attachment;
import nello.model.Experiment;
import nello.model.Log;
import nello.observer.ExperimentObserver;

import java.util.Date;
import java.util.List;

public interface ExperimentObservable {

    long getId();
    Experiment.Category getCategory();
    Experiment.Phase getPhase();
    String getBusinessOwner();
    String getDescription();
    String getName();
    Experiment.StatusColor getStatusColor();

    Date getCreateDate();

    Date getEndDate();
    String getStatus();
    List<Log> getLogs();
    List<Attachment> getAttachments();
    List<String> getIncomes();
    List<String> getCosts();
    boolean isLocked();

    Date getLastModified();

    /**
     * Notifies all registered observers that there has been an update
     *
     * @author Valerie Timmerman
     */

    void notifyObservers();

    void registerObserver(ExperimentObserver observer);

}
