package nello.model;

public enum UserRole {
    GUEST(1),
    WORKER(2),
    ADMIN(3);

    private final int role;

    UserRole(int role) {
        this.role = role;
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

}
