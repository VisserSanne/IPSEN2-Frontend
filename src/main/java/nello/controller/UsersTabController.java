package nello.controller;

import nello.model.User;
import nello.model.UsersTabModel;
import nello.observer.UsersTabObserver;
import nello.view.AlertBox;
import nello.view.ProfileView;

import javax.ws.rs.core.Response;
import java.util.logging.Level;

public class UsersTabController implements IController {
    private MainController mainController;
    private UsersTabModel usersTabModel;

    public UsersTabController(MainController mainController, UsersTabModel usersTabModel) {
        this.mainController = mainController;
        this.usersTabModel = usersTabModel;
    }

    public void registerObserver(UsersTabObserver o){
        usersTabModel.registerObserver(o);
    }

    public void onEditButtonClick(long id) {
        HTTPController http = mainController.getHttpController();
        User user = usersTabModel.getUser();
        Response response = http.get("/users/" + user.getId());
        switch (response.getStatus()){
            case 200:
                User u = response.readEntity(User.class);
                mainController.getProfileController().setUser(u);
                mainController.getStageController().displayView(new ProfileView());
                break;
            case 401:
                usersTabModel.setMessage("De ingevoerde ID bestaat niet.");
                break;
        }

    }

    public void onDeleteButtonClick(long id) {
        HTTPController http = mainController.getHttpController();
        User user = usersTabModel.getUser();
        Response response = http.delete("/users/" + user.getId(), user);
        switch (response.getStatus()){
            case 200:
                mainController.getStageController().displayPopup(new AlertBox("Gebruiker is verwijderd.", Level.FINE, 3));
                break;
        }

    }
}
