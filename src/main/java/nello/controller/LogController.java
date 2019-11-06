package nello.controller;

import nello.model.Log;
import nello.observer.LogObserver;

public class LogController implements IController {

    private MainController mainController;
    private Log log;

    public void registerObserver(LogObserver observer) {
        log.registerObserver(observer);
    }

    public LogController(MainController mainController, Log log) {
        this.mainController = mainController;
        this.log = log;
    }

    public void addLogItem() {

    }

}
