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

    public void getMember(String value){
        //Todo: search database for member with name==value or emailadres==value
    }

    public void cancel(){
        //Todo: close view
    }

    public void registerObserver(AddMembersObserver observer) {
        model.registerObserver(observer);
    }

}
