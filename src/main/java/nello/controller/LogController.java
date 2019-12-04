package nello.controller;

import nello.model.Experiment;
import nello.model.Log;
import nello.model.User;

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
     * @param id     id of the experiment it belongs to
     * @param status new status that is set
     * @param person the person who made the new log item
     * @author Valerie Timmerman
     */

    public void addLogItem(Experiment experiment, String oldStatus, User user) {
        System.out.println("calleD");
        Log log = new Log(experiment, oldStatus, user.getNetworkMember().getName());
        String route = "log/create/" + experiment.getId() + "/" + oldStatus + "/" + user.getNetworkMember().getName();
        System.out.println(route);
        Response response = mainController.getHttpController().post(route, log);
        System.out.println(response.readEntity(String.class));
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public void getLogByExperiment(Experiment experiment) {
        HTTPController http = new HTTPController();
        Response response = http.get("/log/" + experiment.getId());

        System.out.println("shit");
        if (response.getStatus() == 200) {
            Log[] logs = response.readEntity(Log[].class);
            experiment.setLogs(logs);
        }

    }

}

