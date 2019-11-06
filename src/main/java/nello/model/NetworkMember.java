package nello.model;

public class NetworkMember {
    private Boolean isBusiness;
    private long id;
    private String name;

    public NetworkMember(long id, String name, Boolean isBusiness) {
        this.id = id;
        this.name = name;
        this.isBusiness = isBusiness;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(Boolean business) {
        this.isBusiness = business;
    }

}
