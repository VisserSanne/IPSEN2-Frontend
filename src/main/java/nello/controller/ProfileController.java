package nello.controller;

import nello.model.ProfileModel;
import nello.model.User;
import nello.observer.ProfileObserver;
import nello.view.AlertBox;
import nello.view.DashboardView;
import nello.view.TabView;
import nello.view.UsersTabView;

import javax.ws.rs.core.Response;
import java.util.logging.Level;

public class ProfileController implements IController {
    private MainController mainController;
    private ProfileModel profileModel;

    public ProfileController(MainController mainController, ProfileModel profileModel) {
        this.mainController = mainController;
        this.profileModel = profileModel;
    }

    public void onBackButtonClick() {
        mainController.getDashboardController().onGebruikersClick();
    }

    public void onSaveButtonClick(String firstName, String lastName, String email, String password, String newPassword, String confirmNewPassword){
        HTTPController http = mainController.getHttpController();
        User user = profileModel.getUser();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
//            mainController.getStageController().displayPopup(new AlertBox("Een van de velden is leeg.", Level.WARNING, 3));
            return;
        }
        user.getNetworkMember().setName(firstName + " " + lastName);

        if (! user.getPassword().equals(password)) {
//            mainController.getStageController().displayPopup(new AlertBox("De oude wachtwoordt komt niet overeen.", Level.WARNING, 3));
            return;
        }
        user.setEmail(email);

        if (! newPassword.equals(confirmNewPassword)) {
//            mainController.getStageController().displayPopup(new AlertBox("De nieuwe wachtwoorden komen niet overeen.", Level.WARNING, 3), 200, 200);
            return;
        }
        user.setPassword(newPassword);

        Response response = http.put("/users/" + user.getId(), user);
        mainController.getStageController().displayPopup(new AlertBox("Profiel succesvol geupdated.", Level.FINE, 3));
    }

    public void registerObserver(ProfileObserver observer) {
        profileModel.registerObserver(observer);
    }

    public void setUser(User u) {
        profileModel.setUser(u);
    }

    public MainController getMainController() {
        return mainController;
    }
}
