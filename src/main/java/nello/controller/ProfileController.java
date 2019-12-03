package nello.controller;

import nello.model.ProfileModel;
import nello.model.User;
import nello.model.UserRole;
import nello.observer.ProfileObserver;
import nello.view.AlertBox;

import java.util.logging.Level;

public class ProfileController implements IController {
    private MainController mainController;
    private ProfileModel profileModel;
    private UserRole[] userRoles = new UserRole[]{UserRole.GUEST, UserRole.WORKER, UserRole.ADMIN};

    public ProfileController(MainController mainController, ProfileModel profileModel) {
        this.mainController = mainController;
        this.profileModel = profileModel;
    }

    public void onBackButtonClick() {
        mainController.getDashboardController().onGebruikersClick();
    }

    public void onSaveButtonClick(String firstName, String lastName, String email, String userRole, String password, String newPassword, String confirmNewPassword) {
        User user = profileModel.getUser();

        if (saveProfileChecker(firstName, lastName, email, userRole)) {
            user.getNetworkMember().setName(firstName + " " + lastName);
            user.setRole(getUserRoleValue(userRole));
        }

        if (profilePasswordChecker(password, newPassword, confirmNewPassword, user)) {
            mainController.getUserController().updatePassword(user, password, newPassword);
        }

        mainController.getUserController().updateUser(user);
    }

    public boolean saveProfileChecker(String firstName, String lastName, String email, String userRole) {
        //            mainController.getStageController().displayPopup(new AlertBox("Een van de velden is leeg.", Level.WARNING, 3));
        return !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !userRole.isEmpty();
    }

    public boolean profilePasswordChecker(String password, String newPassword, String confirmNewPassword, User user) {
        // als wachtwoord leeg is, return false zodat password niet wordt geupdate.
        if (password.isEmpty())
            return false;

        if (!newPassword.isEmpty() && !confirmNewPassword.isEmpty()) {

            if (newPassword.equals(confirmNewPassword)) {
                mainController.getStageController().displayPopup(new AlertBox("De nieuwe wachtwoorden komen niet overeen.", Level.WARNING, 3), 200, 200);
                return true;
            }
        }
        return false;
    }

    public void registerObserver(ProfileObserver observer) {
        profileModel.registerObserver(observer);
    }

    public UserRole getUserRoleValue(String userRole) {
        for (UserRole role : this.getUserRoles()) {
            if (role.getName().equals(userRole)) {
                return role;
            }
        }
        return null;
    }

    public void setUser(User u) {
        profileModel.setUser(u);
    }

    public MainController getMainController() {
        return mainController;
    }

    public UserRole[] getUserRoles() {
        return userRoles;
    }
}
