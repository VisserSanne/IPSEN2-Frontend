package nello.controller;

public enum ResourceRoute {
    LOGIN("/login"), LOGIN_EMAIL("/login/email"),
    EXPERIMENT_CREATE(""), LOG_CREATE("/log/create");

    private String route;

    ResourceRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return route;
    }
}
