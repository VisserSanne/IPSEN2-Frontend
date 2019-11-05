package nello.controller;

import nello.model.Attachment;
import nello.model.Experiment;
import nello.model.Log;
import nello.observer.ExperimentObserver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class ExperimentController implements IController {

    private MainController mainController;
    private Experiment experiment;

    public ExperimentController(MainController mainController, Experiment experiment) {
        this.mainController = mainController;
        this.experiment = experiment;
    }

    public void registerObserver(ExperimentObserver observer) {
        experiment.registerObserver(observer);
    }

    /**
     * Creates a new Experiment with the data passed through by the view
     *
     * @param isService boolean that tells if the experiment is a service
     * @param businessOwner String of the person for whom the experiment is
     * @param description String of a short description for the experiment
     * @param name String with the name of the experiment itself
     * @author Valerie Timmerman
     */

    public void create(boolean isService, String businessOwner, String description, String name) {

        Experiment.Category category = null;
        Experiment.Phase phase = null;

        if(isService) {
            category = Experiment.Category.getById(3);
            phase = Experiment.Phase.getById(5);
        } else {
            category = Experiment.Category.getById(1);
            phase = Experiment.Phase.getById(1);
        }

        new Experiment(generateId(), category, phase, businessOwner, description, name, "GREEN", getDate(),
                null, new ArrayList<Log>(), new ArrayList<Attachment>(), false);

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
     * Generates a random number of 6 digits long as id
     *
     * @return long id
     * @author Valerie Timmerman
     */

    public long generateId() {
        //TODO: make something better
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public void endExperiment(boolean succesfull) {

        if(succesfull) {

        } else {

        }

    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

}