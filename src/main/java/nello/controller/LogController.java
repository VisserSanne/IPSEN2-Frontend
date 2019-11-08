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

    /**
     * Adds a new log item in the logs and sends it to the backend
     *
     * @param id id of the experiment it belongs to
     * @param status new status that is set
     * @param person the person who made the new log item
     * @author Valerie Timmerman
     */

    public void addLogItem(long id, String status, String person) {
        Log log = new Log(id, status, person, LocalDateTime.now());
        mainController.getHttpController().post("log/create", log);
    }

    public void setLog(Log log) {this.log = log;}

}
