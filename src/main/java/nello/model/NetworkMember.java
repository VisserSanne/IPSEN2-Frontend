package nello.model;

public class NetworkMember {
    private Boolean isBusiness;
    private long id;
    private String firstName;
    private String lastName;

    public NetworkMember(long id, String firstName, String lastName, Boolean isBusiness) {
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
