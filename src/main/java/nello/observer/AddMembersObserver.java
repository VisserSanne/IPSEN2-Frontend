package nello.observer;

import nello.model.AddMembersModel;
import nello.observable.AddMembersObservable;

public interface AddMembersObserver {

    void update(AddMembersObservable observable);
}
