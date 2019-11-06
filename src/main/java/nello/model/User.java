package nello.model;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class User {
    private long id;

    @Expose
    private NetworkMember networkMember;

    @Expose
    private String email;

    @Expose
    private String password;

    @Expose
    private UserRole role;

    private Date createDate;

    public User() {
        this.networkMember = new NetworkMember("", false);
    }

    public User(
            NetworkMember networkMember,
            String email,
            String password,
            UserRole role,
            Date createDate) {
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

    public UserRole getUserRole() {
        return role;
    }

    public void setUserRole(UserRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
