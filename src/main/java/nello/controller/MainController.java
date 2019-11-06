package nello.controller;

import nello.model.DashboardModel;
import nello.model.LoginModel;
import nello.model.ProfileModel;

public class MainController {

    private static MainController instance;
    private HTTPController httpController;
    private StageController stageController;
    private LoginController loginController;
    private DashboardController dashboardController;
    private ProfileController profileController;

    private MainController() {
        registerControllers();
    }

    public static MainController getInstance() {
        if (instance == null)
            instance = new MainController();
        return instance;
    }

    private void registerControllers() {
        httpController = new HTTPController();
        stageController = new StageController();
        loginController = new LoginController(this, new LoginModel());
        dashboardController = new DashboardController(this, new DashboardModel());
        profileController = new ProfileController(this, new ProfileModel());
    }

    public HTTPController getHttpController() {
        return httpController;
    }

    public StageController getStageController() {
        return stageController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public DashboardController getDashboardController() {
        return dashboardController;
    }

    public ProfileController getProfileController() {
        return profileController;
    }
}
