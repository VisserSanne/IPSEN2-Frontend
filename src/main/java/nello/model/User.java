package nello.model;

import java.util.Date;

public class User {

    private long id;
    private NetworkMember networkMember;
    private String email;
    private String password;
    private UserRole role;
    private Date createDate;

    public User(
            long id,
            NetworkMember networkMember,
            String email,
            String password,
            UserRole role,
            Date createDate)

    {
        this.id = id;
        this.networkMember = networkMember;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
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

    public UserRole getUserRole() {
        return role;
    }

    public void setUserRole(UserRole role) {
        this.role = role;
    }
}
