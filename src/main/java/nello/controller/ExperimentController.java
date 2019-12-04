package nello.controller;

import nello.model.Experiment;
import nello.model.NetworkMember;
import nello.observer.ExperimentObserver;
import nello.view.EditExperimentView;
import nello.view.ExperimentOverviewView;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

public class ExperimentController implements IController {
    private MainController mainController;
    private Experiment experiment;

    public ExperimentController(MainController mainController) {
        this.mainController = mainController;
    }

    public void registerObserver(ExperimentObserver observer) {
        experiment.registerObserver(observer);
    }

    public List<Experiment> list() {
        Response response = mainController.getHttpController().get("/experiments/");
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(new GenericType<List<Experiment>>() {
                });
        }

        return null;
    }


    /**
     * Creates a new Experiment with the data passed through by the view
     *
     * @param isService   boolean that tells if the experiment is a service
     * @param description String of a short description for the experiment
     * @param name        String with the name of the experiment itself
     * @author Valerie Timmerman
     */
    public void create(boolean isService, Experiment.Phase phase, String name, String description) {
        Experiment.Category category = null;

        if (isService) {
            category = Experiment.Category.VASTEDIENST;
            phase = Experiment.Phase.VASTEDIENST;
        } else {
            category = Experiment.Category.INWERKING;
        }

        Experiment experiment = new Experiment(category, name, phase, "", "", description, Experiment.StatusColor.GROEN);

        Response response = mainController.getHttpController().post("/experiments", experiment);

        setExperiment(experiment);
        mainController.getStageController().displayPopup(new ExperimentOverviewView());

        if (response.getStatus() == 200) {
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

        if (successful) {
            experiment.setCategory(Experiment.Category.AFGEROND);
        } else {
            experiment.setCategory(Experiment.Category.VASTEDIENST);
        }

        experiment.setPhase(Experiment.Phase.AFGEROND);
        experiment.setStatusColor(Experiment.StatusColor.GROEN);
        experiment.setEndDate(getDate());

        Response response = mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);

        if (response.getStatus() == 200) {
            mainController.getDashboardController().loadExperiments();
        }

    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Experiment getExperiment() {
        return this.experiment;
    }

    /**
     * Edits the experiment after changes are made in the edit view
     *
     * @param name        edited name
     * @param description edited description
     * @param status      new status
     * @author Valerie Timmerman
     */

    public void updateExperiment(String name, String description, String status) {
//
//        experiment.setName(name);
//        experiment.setDescription(description);
//
//        mainController.getLogController().addLogItem(experiment, status, "Dummy");
//        mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);

    }

    public void pickAttachment() {
        mainController.getAttachmentController().pickAttachment();
    }

    public void onExperimentSave(Experiment experiment) {
        this.create(experiment);
    }

    private void create(Experiment experiment) {
        Response response = mainController.getHttpController().post("/experiments", experiment);
        System.out.println(response.readEntity(String.class));
        if (response.getStatus() == 200) {
            mainController.getDashboardController().loadExperiments();
        }
    }

    public void onNameChange(String name) {
        if (!experiment.getName().equalsIgnoreCase(name))
            experiment.setName(name);
    }

    public void onDescriptionChange(String description) {
        if (!experiment.getDescription().equalsIgnoreCase(description))
            experiment.setDescription(description);
    }

    public void onStatusChange(String status) {
        if (!experiment.getStatus().equalsIgnoreCase(status))
            experiment.setStatus(status);
    }

    public void onOwnerChange(String owner) {
        if (!experiment.getBusinessOwner().equalsIgnoreCase(owner))
            experiment.setBusinessOwner(owner);
    }

    public void onAddCost(String costItem) {
        if (!experiment.getCosts().contains(costItem))
            experiment.addCost(costItem);
    }

    public void onAddIncome(String income) {
        if (!experiment.getIncomes().contains(income))
            experiment.addIncome(income);
    }

    public void onAddNetworkMember(String memberName, boolean isBusiness) {
        NetworkMember networkMember = mainController.getNetworkmemberController().getNetworkmember(memberName);

        if (networkMember == null) {
            networkMember = mainController.getNetworkmemberController().createnetworkmember(memberName, isBusiness);
        }

        if (experiment.getId() == 0) {
            experiment.setId(list().size() + 1);
        }

        if (!mainController.getTeamController().hasNetworkmember(experiment.getId(), networkMember.getId())) {
            mainController.getTeamController().createTeam(experiment, networkMember);
        }

        mainController.getDashboardController().loadDashboard();
    }


    public void onEditButtonClick(String oldStatus) {
        mainController.getStageController().closeAllView();
        EditExperimentView editView = new EditExperimentView(false, oldStatus);
        editView.getController().setExperiment(this.experiment);

        mainController.getStageController().displayPopup(editView);

        if (isLocked(experiment.getId())) {
            editView.disableEditExperimentItems(true);
        } else {
            lockExperiment(experiment, true);
        }
    }

    private void updateExperiment(Experiment experiment) {
        Response response = mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);
        System.out.println("updating");
        System.out.println(response.readEntity(String.class));
        if (response.getStatus() == 200) {
            mainController.getDashboardController().loadExperiments();
        }

        lockExperiment(experiment, false);
    }

    private void lockExperiment(Experiment experiment, boolean isLocked) {
        experiment.setLocked(isLocked);
        Response response = mainController.getHttpController().put("/experiments/" + experiment.getId(), experiment);
    }

    private boolean isLocked(long experimentId) {
        // TODO: 30/11/2019 check for date last_modified
        Response response = mainController.getHttpController().get("/experiments/" + experimentId);
        if (response.getStatus() == 200) {
            return response.readEntity(Experiment.class).isLocked();
        }
        return false;
    }

    public void onStatusColorChange(Experiment.StatusColor statusColor) {
        experiment.setStatusColor(statusColor);
    }

    public void onSaveButtonClick(boolean isNew, String oldStatus) {
        if (isNew) {
            mainController.getExperimentController().create(experiment);
            return;
        } else {
            if (oldStatus != null || !oldStatus.isEmpty())
                mainController.getLogController().addLogItem(experiment, oldStatus, mainController.getProfileController().getUser());
            mainController.getExperimentController().updateExperiment(experiment);
        }

    }

    public void onFinishButtonClick() {

    }

    public void onPhaseChange(Experiment.Phase phase) {
        experiment.setPhase(phase);
    }

    public void onCategoryChange(Experiment.Category category) {
        experiment.setCategory(category);
    }
}
