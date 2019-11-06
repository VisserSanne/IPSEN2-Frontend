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

    public String getInitials() {
        String[] tokens = this.name.split(" ");
        String firstName = tokens[0];
        String lastName = tokens[tokens.length -1];
        String initials = "";
        if(tokens.length > 0) {
            String[] firstToken = firstName.split("");
            String firstInitial = firstToken[0];

            String[] lastToken = lastName.split("");
            String lastInitial = lastToken[0];

            initials = firstInitial+ "." +lastInitial+ ".";
        }
        return initials;
    }

}
