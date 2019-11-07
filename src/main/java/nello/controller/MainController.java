package nello.controller;

import nello.model.AddMembersModel;
import nello.model.LoginModel;
import nello.model.ProfileModel;

public class MainController {


    private static MainController instance;
    private HTTPController httpController;
    private StageController stageController;
    private LoginController loginController;
    private AddMembersController addMembersController;
    private ProfileController profileController;
    private ChangePhaseController changePhaseController;


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
        addMembersController = new AddMembersController(this, new AddMembersModel());
        profileController = new ProfileController(this, new ProfileModel());
        changePhaseController = new ChangePhaseController(this);
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

    public AddMembersController getAddMembersController(){
        return addMembersController;
    }

    public ProfileController getProfileController() {
        return profileController;
    }

    public ChangePhaseController getChangePhaseController() {
        return changePhaseController;
    }
}
