package nello.model;

public class Team {
    private long id;
    private long experimentId;
    private boolean isEinstein;
    private boolean isProjectLeader;
    private boolean business;
    private long networkmemberId;

    public Team() {
    }

    public Team(
            long experimentId,
            boolean isEinstein,
            boolean isProjectLeader,
            long networkmemberId
    ) {
        this.experimentId = experimentId;
        this.isEinstein = isEinstein;
        this.isProjectLeader = isProjectLeader;
        this.networkmemberId = networkmemberId;
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

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public boolean isEinstein() {
        return isEinstein;
    }

    public void setEinstein(boolean einstein) {
        isEinstein = einstein;
    }

    public boolean isProjectLeader() {
        return isProjectLeader;
    }

    public void setProjectLeader(boolean projectLeader) {
        isProjectLeader = projectLeader;
    }

    public long getNetworkmemberId() {
        return networkmemberId;
    }

    public void setNetworkmemberId(long networkmemberId) {
        this.networkmemberId = networkmemberId;
    }
}
