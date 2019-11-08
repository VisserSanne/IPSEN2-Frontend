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

    public void onMenuButtonClick() {

    }

    public void onAddExperimentClick(Experiment.Phase vastedienst, MouseEvent event) {
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

    public void onExperimentClick(Experiment experiment) {
        mainController.getExperimentController().setExperiment(experiment);
        mainController.getStageController().displayPopup(new ExperimentOverviewView());
    }
}
