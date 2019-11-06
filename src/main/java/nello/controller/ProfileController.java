package nello.controller;

import nello.model.ProfileModel;
import nello.model.User;
import nello.observer.ProfileObserver;

public class ProfileController implements IController {
    private MainController mainController;
    private ProfileModel profileModel;

    public ProfileController(MainController mainController, ProfileModel profileModel) {
        this.mainController = mainController;
        this.profileModel = profileModel;
    }

    public void onSaveButtonClick(){
        HTTPController http = mainController.getHttpController();
        User user = profileModel.getUser();
        //
    }

    public void onEmailChange(String email){
        //
    }

    public void onFullNameChange(String fullName){
        //
    }


    public void registerObserver(ProfileObserver observer) {
        profileModel.registerObserver(observer);
    }
}
