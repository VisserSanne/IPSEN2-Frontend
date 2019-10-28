package nello.view;

import nello.controller.IController;

public interface FXMLView<C extends IController> {

    String getFXMLPath();

    C getController();

    void setController(C controller);

}
