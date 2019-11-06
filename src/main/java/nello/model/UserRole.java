package nello.model;

public enum UserRole {
    GUEST(1, "Gastgebruiker"),
    WORKER(2, "TestlabOM medewerker"),
    ADMIN(3, "Administrator");

    private final int role;
    private final String name;

    UserRole(int role, String name) {
        this.role = role;
        this.name = name;
    }

    public static UserRole getById(int roleId) {
        for (UserRole role : values()) {
            if (role.getValue() == roleId) {
                return role;
            }
        }
        return UserRole.GUEST;
    }

    public int getValue() {
        return role;
    }

    public String getName() {
        return name;
    }

}
