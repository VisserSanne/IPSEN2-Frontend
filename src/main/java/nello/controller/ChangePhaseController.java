package nello.controller;

import nello.model.ChangePhaseModel;
import nello.observer.ChangePhaseObserver;

public class ChangePhaseController implements IController {

    private MainController mainController;
    private ChangePhaseModel model;

    public ChangePhaseController(MainController mainController, ChangePhaseModel model){
        this.mainController = mainController;
        this.model = model;
    }

    public void registerObserver(ChangePhaseObserver observer) {
        model.registerObserver(observer);
    }


}
