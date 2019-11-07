package nello.model;

import com.google.gson.annotations.Expose;

public class NetworkMember {
    private long id;

    @Expose
    private String name;

    @Expose
    private Boolean isBusiness;

    public NetworkMember(String name, Boolean isBusiness) {
        this.id = id;
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

}
