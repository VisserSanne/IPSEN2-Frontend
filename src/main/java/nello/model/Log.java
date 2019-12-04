package nello.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Log {

    private long id;
    private long experimentId;
    private String status;
    private String person;
    private Date createDateTime;

    /**
     * Creates a Log object from json file send by frontend
     *
     * @param experimentId long
     * @param status       String
     * @param person       String
     */

    @JsonCreator
    public Log(
            @JsonProperty("experimentId") long experimentId,
            @JsonProperty("status") String status,
            @JsonProperty("person") String person,
            @JsonProperty("createDateTime") Date createDateTime
    ) {
        this.experimentId = experimentId;
        this.status = status;
        this.person = person;
        this.createDateTime = createDateTime;
    }

    public Log(Experiment experiment, String status, String name) {
        this(experiment.getId(), status, name, null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExperimentId() {
        return experimentId;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public String getPerson() {
        return person;
    }

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd'T'HH:mm:ss.SSS")
    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

}
