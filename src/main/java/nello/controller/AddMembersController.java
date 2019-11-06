package nello.controller;

import nello.model.AddMembersModel;
import nello.observer.AddMembersObserver;

public class AddMembersController implements IController {

    private MainController mainController;
    private AddMembersModel model;


    public AddMembersController(MainController mainController, AddMembersModel model) {
        this.mainController = mainController;
        this.model = model;
    }

    public void registerObserver(AddMembersObserver observer) {
        model.registerObserver(observer);
    }

}
