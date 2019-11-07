package nello.controller;

import nello.model.UsersTabModel;
import nello.observer.UsersTabObserver;

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
        //

    }

    public void onDeleteButtonClick(long id) {
        //
    }
}
