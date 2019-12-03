package nello.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import nello.model.DashboardModel;
import nello.model.Experiment;
import nello.model.NetworkMember;
import nello.model.Team;
import nello.observer.DashboardObserver;
import nello.view.*;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;

public class DashboardController implements IController {
    private MainController mainController;
    private DashboardModel dashboardModel;
    private boolean hasSearch;

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
        EditExperimentView view = new EditExperimentView(true);
        Experiment experiment = new Experiment(Experiment.Category.INWERKING, phase);
        view.getController().setExperiment(experiment);
        mainController.getStageController().displayPopup(view);
    }

    /**
     * Register observers to model.
     *
     * @param observer {@link DashboardObserver} login observer.
     */
    public void registerObserver(DashboardObserver observer) {
        dashboardModel.registerObserver(observer);
    }

    public void loadDashboard() {
        this.loadExperiments();
        this.loadTeams();
        this.loadNetworkMembers();
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
     * laad experiment vanuit backend.
     * @return
     */
    public void loadTeams() {
        List<Team> teamList = mainController.getTeamController().list();
        dashboardModel.setTeamList(teamList);
    }

    /**
     * laad experiment vanuit backend.
     * @return
     */
    public void loadNetworkMembers() {
        List<NetworkMember> networkMemberList = mainController.getNetworkmemberController().list();
        dashboardModel.setNetworkMembers(networkMemberList);
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

    public void onFilter(Experiment.StatusColor status) {
        List<Experiment> filterList = Arrays.stream(dashboardModel.getExperimentList())
                .filter(experiment -> experiment.getStatusColor().equals(status))
                .collect(Collectors.toList());
        dashboardModel.setExperimentList(filterList.toArray(new Experiment[0]));
    }

    /**
     * hasSearch an experiment by name
     *
     * @param searchText
     */
    public void onSearch(String searchText) {
        this.hasSearch = true;
        this.loadExperiments();
        List<Experiment> filterList = Arrays
                .stream(dashboardModel.getExperimentList())
                .filter(experiment -> experiment.getName().contains(searchText))
                .collect(Collectors.toList());
        dashboardModel.setExperimentList(filterList.toArray(new Experiment[0]));
    }

    public void onClearButtonClick() {
        this.loadExperiments();
    }
}
