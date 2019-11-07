package nello.model;

import nello.observer.ChangePhaseObserver;

import java.util.ArrayList;
import java.util.List;

public class ChangePhaseModel {

    private List<ChangePhaseObserver> observerList;

    public ChangePhaseModel() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (ChangePhaseObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(ChangePhaseObserver observer) {
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }

}
