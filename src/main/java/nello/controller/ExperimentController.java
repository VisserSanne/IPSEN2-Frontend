package nello.controller;

import nello.model.Experiment;
import nello.observer.ExperimentObserver;
import nello.view.ExperimentOverviewView;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;

public class ExperimentController implements IController {
    // TODO: 27/11/2019 link log cost income users, network, member and team to the object
    private MainController mainController;
    private Experiment experiment;

    public ExperimentController(MainController mainController) {
        this.mainController = mainController;
    }

    public void registerObserver(ExperimentObserver observer) {
        experiment.registerObserver(observer);
    }

    /**
     * Creates a new Experiment with the data passed through by the view
     *
     * @param isService boolean that tells if the experiment is a service
     * @param description String of a short description for the experiment
     * @param name String with the name of the experiment itself
     * @author Valerie Timmerman
     */

    public void create(boolean isService, Experiment.Phase phase, String name, String description) {

        Experiment.Category category = null;

        if(isService) {
            category = Experiment.Category.VASTEDIENST;
            phase = Experiment.Phase.VASTEDIENST;
        } else {
            category = Experiment.Category.INWERKING;
        }

        Experiment experiment = new Experiment(category, name, phase, "", "", description, Experiment.StatusColor.GROEN);

        Response response = mainController.getHttpController().post("/experiments", experiment);

        setExperiment(experiment);
        mainController.getStageController().displayPopup(new ExperimentOverviewView());

        System.out.println(response.getStatus());

        if(response.getStatus() == 200) {
            mainController.getDashboardController().loadExperiments();
        }

    }

    /**
     * Gets the date of today
     *
     * @return LocalDate of today
     * @author Valerie Timmerman
     */

    public Date getDate() {
        return new Date();
    }

    /**
     * Sets the state of an experiment to ended, with the correct phase
     *
     * @param successful boolean that is given by the view if the experiment has succeeded
     * @author Valerie Timmerman
     */

    public void endExperiment(boolean successful) {

        if(successful) {
            experiment.setCategory(Experiment.Category.HALLOFFAME);
        } else {
            experiment.setCategory(Experiment.Category.CEMENTARY);
        }

        experiment.setPhase(Experiment.Phase.AFGEROND);
        experiment.setStatusColor(Experiment.StatusColor.GROEN);
        experiment.setEndDate(getDate());

        Response response = mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);

        if(response.getStatus() == 200) {
            mainController.getDashboardController().loadExperiments();
        }

    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Edits the experiment after changes are made in the edit view
     *
     * @param name edited name
     * @param description edited description
     * @param status new status
     * @author Valerie Timmerman
     */

    public void updateExperiment(String name, String description, String status) {

        experiment.setName(name);
        experiment.setDescription(description);

        mainController.getLogController().addLogItem(experiment.getId(), status, "Dummy");
        mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);

    }

    public void pickAttachment(){
        mainController.getAttachmentController().pickAttachment();
    }
}
