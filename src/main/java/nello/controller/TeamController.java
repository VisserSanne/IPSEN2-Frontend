package nello.controller;

import nello.model.Experiment;
import nello.model.NetworkMember;
import nello.model.Team;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class TeamController {
    private MainController mainController;
    private Team team;

    public TeamController(MainController mainController, Team team) {
        this.mainController = mainController;
        this.team = team;
    }

    public List<Team> list() {
        Response response = mainController.getHttpController().get("/teams/");
        switch (response.getStatus()) {
            case 200:
                System.out.println("found");
                return response.readEntity(new GenericType<List<Team>>(){});
        }

        return null;
    }


    public List<Team> getTeam(long id) {
        Response response = mainController.getHttpController().get("/teams/" + id);
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(new GenericType<List<Team>>(){});
        }

        return null;
    }

    public Team createTeam(Experiment experiment, NetworkMember networkMember) {
        Response response = mainController.getHttpController().post("/teams/",
                new Team(
                        experiment.getId(),
                        false,
                        false,
                        networkMember.getId()
                )
        );
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(Team.class);
        }

        return null;
    }

    public void addNetworkmember(long experimentId, NetworkMember networkMember) {

    }

    public boolean hasNetworkmember(long experimentId, long networkMemberId) {
        List<Team> teams = mainController.getTeamController().getTeam(experimentId);

        for (Team team : teams) {
            System.out.println("team.getNetworkmemberId() " + team.getNetworkmemberId());
            System.out.println("networkMemberId " + networkMemberId);
            if (team.getNetworkmemberId() == networkMemberId) {

                return true;
            }
        }
        return false;
    }
}
