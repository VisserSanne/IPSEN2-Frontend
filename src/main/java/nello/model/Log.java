package nello.model;

import java.time.LocalDateTime;

public class Log {

    private long experimentID;
    private String status;
    private String person;
    private LocalDateTime createDateTime;

    public Log(long experimentID, String status, String person, LocalDateTime createDateTime) {
        this.experimentID = experimentID;
        this.status = status;
        this.person = person;
        this.createDateTime = createDateTime;
    }

    public long getExperimentID() {
        return experimentID;
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

}
