package nello.model;

import nello.observable.UserRegistrationObservable;
import nello.observer.UserRegistrationObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRegistrationModel implements UserRegistrationObservable {

    private HashMap<String, String> errorMessages;
    private List<UserRegistrationObserver> observableList;

    public UserRegistrationModel() {
        this.errorMessages = new HashMap<>();
        this.observableList = new ArrayList<>();
    }

    @Override
    public void registerObserver(UserRegistrationObserver o) {
        observableList.add(o);
    }

    @Override
    public void notifyObservers() {
        for (UserRegistrationObserver o : observableList) {
            o.update(this);
        }

    }

    @Override
    public HashMap<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setError(String name) {
        this.setError(name, "Dit veld mag niet leeg zijn: " + name);
    }

    public void removeError(String name) {
        errorMessages.remove(name);
    }

    public void clearErrors() {
        errorMessages.clear();
        notifyObservers();
    }

    public void setError(String name, String message) {
        System.out.println(message);
        errorMessages.put(name, message);
        notifyObservers();
    }
}
