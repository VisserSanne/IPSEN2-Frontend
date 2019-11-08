package nello.controller;

import nello.model.Experiment;
import nello.observer.ExperimentObserver;
import nello.view.ExperimentOverviewView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ExperimentController implements IController {

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

    public void create(boolean isService, String description, String name) {

        Experiment.Category category = null;
        Experiment.Phase phase = null;

        if(isService) {
            category = Experiment.Category.VASTEDIENST;
            phase = Experiment.Phase.VASTEDIENST;
        } else {
            category = Experiment.Category.INWERKING;
            phase = Experiment.Phase.IDEE;
        }

        Experiment experiment = new Experiment(category, phase, null, description, name, Experiment.StatusColor.GROEN,
                getDate(),null, null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false, null);

        mainController.getHttpController().post("/experiments/create", experiment);

        setExperiment(experiment);
        mainController.getStageController().displayView(new ExperimentOverviewView());

    }

    /**
     * Gets the date of today
     *
     * @return LocalDate of today
     * @author Valerie Timmerman
     */

    public LocalDate getDate() {
        LocalDateTime today = LocalDateTime.now();
        return today.toLocalDate();
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

        mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);

    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

}
