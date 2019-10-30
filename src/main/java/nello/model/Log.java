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

}
