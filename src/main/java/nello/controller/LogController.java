package nello.controller;

import nello.model.Experiment;
import nello.model.Log;

import javax.ws.rs.core.Response;

public class LogController implements IController {

    private MainController mainController;
    private Log log;

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
//        Log log = new Log(id, status, person, LocalDateTime.now());
//        mainController.getHttpController().post("log/create", log);
    }

    public void setLog(Log log) {this.log = log;}

    public void getLogByExperiment(Experiment experiment) {
        System.out.println("etfdsddfd");
        HTTPController http = new HTTPController();
        Response response = http.get("/log/" + experiment.getId());

        System.out.println("shit");
        if (response.getStatus() == 200) {
            Log[] logs = response.readEntity(Log[].class);
            experiment.setLogs(logs);
        }

    }
}
