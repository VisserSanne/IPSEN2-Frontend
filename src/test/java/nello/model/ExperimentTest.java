package nello.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ExperimentTest {
    Experiment experiment;

    public void setUp(){
        experiment = new Experiment(
                Experiment.Category.INWERKING,
                Experiment.Phase.VASTEDIENST,
                "businessOwner",
                "description",
                "name",
                Experiment.StatusColor.GROEN,
                new Date(2019-12-04),new Date(2019-12-04),
                "status",
                null,
                null,
                null,
                null,
                false,
                new Date(2019-12-04)
        );
    }

    @Test
    public void getCategoryTest(){
        setUp();
        Assert.assertEquals(experiment.getCategory(),Experiment.Category.INWERKING);
    }

    @Test
    public void getPhaseTest(){
        setUp();
        Assert.assertEquals(experiment.getPhase(),Experiment.Phase.VASTEDIENST);
    }

    @Test
    public void getBusinessOwnerTest(){
        setUp();
        Assert.assertEquals(experiment.getBusinessOwner(),"businessOwner");
    }

    @Test
    public void getDescriptionTest(){
        setUp();
        Assert.assertEquals(experiment.getDescription(),"description");
    }

    @Test
    public void getNameTest(){
        setUp();
        Assert.assertEquals(experiment.getName(),"name");
    }

    @Test
    public void getStatusColorTest(){
        setUp();
        Assert.assertEquals(experiment.getStatusColor(),Experiment.StatusColor.GROEN);
    }

    @Test
    public void getCreateDateTest(){
        setUp();
        Assert.assertEquals(experiment.getCreateDate(),new Date(2019-12-04));
    }

    @Test
    public void getEndDateTest(){
        setUp();
        Assert.assertEquals(experiment.getEndDate(),new Date(2019-12-04));
    }

    @Test
    public void getStatusTest(){
        setUp();
        Assert.assertEquals(experiment.getStatus(),"status");
    }

    @Test
    public void isLockedTest(){
        setUp();
        Assert.assertEquals(experiment.isLocked(),false);
    }

    @Test
    public void getLastModifiedTest(){
        setUp();
        Assert.assertEquals(experiment.getLastModified(),new Date(2019-12-04));
    }

}
