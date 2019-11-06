package nello.controller;

import nello.model.Log;
import nello.observer.LogObserver;

import java.time.LocalDateTime;

public class LogController implements IController {

    private MainController mainController;
    private Log log;

    public void registerObserver(LogObserver observer) {
        log.registerObserver(observer);
    }

    public LogController(MainController mainController) {
        this.mainController = mainController;
    }

    public void addLogItem(long id, String status, String person) {
        Log log = new Log(id, status, person, LocalDateTime.now());
        mainController.getHttpController().post(ResourceRoute.LOG_CREATE, log);
    }

    public void setLog(Log log) {this.log = log;}

}
