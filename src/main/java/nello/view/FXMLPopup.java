package nello.view;

import nello.controller.IController;

public interface FXMLPopup<T extends IController> extends FXMLView<T> {

    void setLocation(double x, double y);

}
