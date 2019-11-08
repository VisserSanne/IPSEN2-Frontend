package nello.model;

public class NetworkMember {

    private long id;
    private String name;
    private Boolean isBusiness;

    public NetworkMember() {
        this(null, false);
    }

    public NetworkMember(String name, Boolean isBusiness) {
        this.name = name;
        this.isBusiness = isBusiness;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(Boolean business) {
        this.isBusiness = business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
