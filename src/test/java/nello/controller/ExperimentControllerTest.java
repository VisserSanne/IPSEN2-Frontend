package nello.controller;

import nello.model.Experiment;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExperimentControllerTest {

    private ExperimentController experimentController;
    private MainController mainController;

    @Before
    public void setUp() {
        this.mainController = MainController.getInstance();
        this.experimentController = new ExperimentController(mainController);
    }

    @Test
    public void testDate() {
        Date date = this.experimentController.getDate();
        assertEquals(new Date(), date);
    }

    @Test
    public void testSetExperiment() {
        Experiment experiment = new Experiment();
        this.experimentController.setExperiment(experiment);
        assertEquals(experiment, this.experimentController.getExperiment());
    }

}
