package nello.model;

import java.util.Date;

public class User {
    private long id;
    private NetworkMember networkMember;
    private String email;
    private String password;
    private UserRole role;
    private Date createDate;
    private boolean isWhitelisted;

    public User() {
        /* empty */
    }

    public User(
            NetworkMember networkMember,
            String email,
            String password,
            UserRole role) {
        this.networkMember = networkMember;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NetworkMember getNetworkMember() {
        return networkMember;
    }

    public void setNetworkMember(NetworkMember networkMember) {
        this.networkMember = networkMember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isWhitelisted() {
        return isWhitelisted;
    }

    public void setWhitelisted(boolean whitelisted) {
        isWhitelisted = whitelisted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
