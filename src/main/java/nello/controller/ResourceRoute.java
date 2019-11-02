package nello.controller;

public enum ResourceRoute {
    LOGIN("/login"), LOGIN_EMAIL("/login/email");

    private String route;

    ResourceRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return route;
    }
}
