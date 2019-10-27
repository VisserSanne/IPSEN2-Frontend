package nello.factories;

import nello.view.AbstractFXMLView;
import nello.view.FXMLView;
import nello.view.LoginView;

public class ViewFactory {

    public AbstractFXMLView createView(FXMLView fxmlView) {
        switch (fxmlView) {
            case LOGIN:
                return new LoginView();
        }
        return new LoginView(); // this can't be reached if all enum values are defined in the switch.
    }
}
