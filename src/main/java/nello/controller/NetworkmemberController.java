package nello.controller;

import nello.model.NetworkMember;
import nello.model.User;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class NetworkmemberController {
    private MainController mainController;
    private NetworkMember networkMember;

    public NetworkmemberController (MainController mainController, NetworkMember networkMember) {
        this.mainController = mainController;
        this.networkMember = networkMember;
    }

    public List<NetworkMember> list() {
        Response response = mainController.getHttpController().get("/networkmember/");
        switch (response.getStatus()) {
            case 200:
                System.out.println("succes networkmember");
                return response.readEntity(new GenericType<List<NetworkMember>>(){});
        }

        return null;
    }

    public NetworkMember getNetworkmember(String name) {
        Response response = mainController.getHttpController().get("/networkmember/name/" + name);
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(NetworkMember.class);
        }

        return null;
    }

    public NetworkMember createnetworkmember(String memberName, boolean isBusiness) {
        Response response = mainController.getHttpController().post("/networkmember/", new NetworkMember(memberName, isBusiness));
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(NetworkMember.class);
        }
        return null;
    }
}
