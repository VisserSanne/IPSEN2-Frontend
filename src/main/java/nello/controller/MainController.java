package nello.controller;

import nello.factories.ControllerFactory;

public class MainController {


    private final HTTPController httpController;
    private final StageController stageController;
    private final ControllerFactory factory;

    public MainController() {
        this.factory = new ControllerFactory(this);
        this.httpController = new HTTPController();
        this.stageController = new StageController(this);
    }

    public <T> IController getController(Class<T> type) {
        return factory.create(type.getSimpleName());
    }

    public HTTPController getHttpController() {
        return httpController;
    }

    public StageController getStageController() {
        return stageController;
    }
}
