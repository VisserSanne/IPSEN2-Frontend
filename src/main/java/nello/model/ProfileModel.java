package nello.model;

public class ProfileModel {

    private String role;
    private String fullName;
    private String initials;
    private String emailAddress;
    private String bio;

    public ProfileModel() {
        this.role = role;
        this.fullName = fullName;
        this.initials = initials;
        this.emailAddress = emailAddress;
        this.bio = bio;
    }

    public String getRole() {
        return role;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInitials() {
        return initials;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getBio() {
        return bio;
    }

}
