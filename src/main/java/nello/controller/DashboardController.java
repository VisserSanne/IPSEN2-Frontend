package nello.controller;

import nello.model.DashboardModel;
import nello.observer.DashboardObserver;
import nello.view.ExperimentCreateView;

public class DashboardController implements IController {
    private MainController mainController;
    private DashboardModel dashboardModel;

    public DashboardController(MainController mainController, DashboardModel dashboardModel) {
        this.mainController = mainController;
        this.dashboardModel = dashboardModel;
    }

    public void onMenuButtonClick() {

    }

    public void onAddExperimentClick() {
        mainController.getStageController().displayView(new ExperimentCreateView());
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
        int status = http.get("/experiments").getStatus();
        switch (status) {
            case 200:
                System.out.println("sucess");
                break;
            default:
                System.out.println(String.format("status: %s", status));
        }
    }
}
