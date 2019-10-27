package nello.observable;

import nello.model.Credential;
import nello.model.LoginModel;
import nello.model.ViewMessage;

public interface LoginObservable {

    LoginModel.Phase getCurrentPhase();

    ViewMessage getErrorMessage();

    Credential getCredentials();

    void notifyObservers();
}
