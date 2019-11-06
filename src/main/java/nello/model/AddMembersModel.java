package nello.model;

import nello.observable.AddMembersObservable;
import nello.observer.AddMembersObserver;

import java.util.ArrayList;
import java.util.List;

public class AddMembersModel implements AddMembersObservable {

    private List<AddMembersObserver> observerList;

    public AddMembersModel() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (AddMembersObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(AddMembersObserver observer) {
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }


}
