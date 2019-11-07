package nello.controller;

import nello.model.DashboardModel;
import nello.model.LoginModel;
import nello.model.ProfileModel;
import nello.model.TabModel;

public class MainController {
    private static MainController instance;
    private HTTPController httpController;
    private StageController stageController;
    private LoginController loginController;
    private ExperimentController experimentController;
    private DashboardController dashboardController;
    private ProfileController profileController;
    private TabController tabController;
    private UserController userController;

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
        experimentController = new ExperimentController(this);
        dashboardController = new DashboardController(this, new DashboardModel());
        profileController = new ProfileController(this, new ProfileModel());
        tabController = new TabController(this, new TabModel());
        userController = new UserController(this);
    }

    public DashboardController getDashboardController() {
        return dashboardController;
    }

    public ProfileController getProfileController() {
        return profileController;
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

    public ExperimentController getExperimentController() {
        return experimentController;
    }

    public TabController getTabController() {
        return tabController;
    }

    public UserController getUserController() {
        return userController;
    }
}
