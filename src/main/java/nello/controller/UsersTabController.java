package nello.controller;

import nello.model.NetworkMember;
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
        Response response = http.get("/users/" + id);
        switch (response.getStatus()){
            case 200:
                User u = response.readEntity(User.class);
                mainController.getProfileController().setUser(u);
                mainController.getStageController().displayView(new ProfileView());
                break;
            case 401:
                mainController.getStageController().displayPopup(new AlertBox("Opgegeven ID is onbekend.", Level.FINE, 3));
                break;
        }
    }

    public void onDeleteButtonClick(long id) {
        HTTPController http = mainController.getHttpController();
        Response response = http.delete("/users/" + id);
        System.out.println(response.getStatus());
        switch (response.getStatus()){
            case 200:

                mainController.getUsersTabController().getUsersTabModel().setUserList(mainController.getUserController().listUsers());
//                mainController.getStageController().displayPopup(new AlertBox("Gebruiker is verwijderd.", Level.FINE, 3));
                break;
        }
    }

    public UsersTabModel getUsersTabModel() {
        return usersTabModel;
    }
}
