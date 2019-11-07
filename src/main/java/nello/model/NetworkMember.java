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
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBusiness = isBusiness;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(Boolean business) {
        this.isBusiness = business;
    }

    public String getInitials() {
        String[] firstToken = firstName.split("");
        String firstInitial = firstToken[0];

        String[] multiLastName = lastName.split(" ");
        String singleLastName = multiLastName[multiLastName.length -1];
        String[] lastToken = singleLastName.split("");
        String lastInitial = lastToken[0];

        String initials = firstInitial+lastInitial;

        return initials;
    }

}
