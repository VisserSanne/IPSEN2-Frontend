package nello.controller;

import javafx.scene.input.MouseEvent;
import nello.model.DashboardModel;
import nello.model.Experiment;
import nello.observer.DashboardObserver;
import nello.view.ExperimentCreateView;
import nello.view.ExperimentOverviewView;

import javax.ws.rs.core.Response;

public class DashboardController implements IController {
    private MainController mainController;
    private DashboardModel dashboardModel;

    public DashboardController(MainController mainController, DashboardModel dashboardModel) {
        this.mainController = mainController;
        this.dashboardModel = dashboardModel;
    }


    /**
     * laad opties van experimenten zien.
     *
     * @param experiment
     */
    public void onOpenExperimentClick(Experiment experiment) {
        mainController.getExperimentController().setExperiment(experiment);
        mainController.getStageController().displayPopup(new ExperimentOverviewView());
    }

    public void onProfileClick() {
        Pane usersTabView = mainController.getStageController().getRoot(new UsersTabView());
        Pane profileView = mainController.getStageController().getRoot(new ProfileView());
        mainController.getTabController().getTabModel().setActiveTab("profile");
        mainController.getStageController().displayView(new TabView(profileView, usersTabView));
    }

    public void onGebruikersClick() {
        Pane usersTabView = mainController.getStageController().getRoot(new UsersTabView());
        Pane profileView = mainController.getStageController().getRoot(new ProfileView());
        mainController.getTabController().getTabModel().setActiveTab("gebruikers");
        mainController.getStageController().displayView(new TabView(profileView, usersTabView));
    }

    public void onMenuButtonClick() {

    }

    /**
     * Displays a popup view for adding a new experiment when the correct button is clicked
     *
     * @param phase phase waar een experiment voor komt
     * @param event mouse click event.
     * @author Ashna
     * @author Valerie Timmerman
     */
    public void onAddExperimentClick(Experiment.Phase phase, MouseEvent event) {
        mainController.getStageController().displayPopup(new ExperimentCreateView(), event.getSceneX(), event.getSceneY());
    }

    /**
     * Register observers to model.
     *
     * @param observer {@link DashboardObserver} login observer.
     */
    public void registerObserver(DashboardObserver observer) {
        dashboardModel.registerObserver(observer);
    }

    /**
     * laad experiment vanuit backend.
     */
    public void loadExperiments() {
        HTTPController http = mainController.getHttpController();
        Response response = http.get("/experiments");
        switch (response.getStatus()) {
            case 200:
                System.out.println("sucess");
                dashboardModel.setExperimentList(response.readEntity(Experiment[].class));
                break;
            default:
                System.out.println(String.format("status: %s", response.getStatus()));
        }
    }

    /**
     * handel experiment click event af.
     *
     * @param experiment experiment.
     */
    public void onExperimentClick(Experiment experiment) {
        mainController.getExperimentController().setExperiment(experiment);
        mainController.getStageController().displayPopup(new ExperimentOverviewView());
    }
}
