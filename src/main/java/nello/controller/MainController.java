package nello.controller;

import nello.model.*;


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
    private UserRegistrationController userRegistrationController;
    private LogController logController;

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
        userRegistrationController = new UserRegistrationController(this, new UserRegistrationModel());
        tabController = new TabController(this, new TabModel());
        userController = new UserController(this);
        logController = new LogController(this);
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

    public UserRegistrationController getUserRegistrationController() {
        return userRegistrationController;
    }

    public TabController getTabController() {
        return tabController;
    }

    public UserController getUserController() {
        return userController;
    }

    public LogController getLogController() { return logController; }

}
