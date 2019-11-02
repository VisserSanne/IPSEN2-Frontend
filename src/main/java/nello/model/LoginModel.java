package nello.model;

import nello.observable.LoginObservable;
import nello.observer.LoginObserver;

import java.util.ArrayList;
import java.util.List;

public class LoginModel implements LoginObservable {
    /**
     * global login message
     */
    private String message;
    /**
     * observers list.
     */
    private List<LoginObserver> observerList;
    /**
     * user login credentials
     */
    private Credential credential;
    /**
     * currentPhase of this model.
     */
    private Phase currentPhase;

    /**
     * construct a new LoginModel
     */
    public LoginModel() {
        this.message = "";
        this.currentPhase = Phase.EMAIL;
        this.observerList = new ArrayList<>();
        this.credential = new Credential();
    }

    public void setEmailAddress(String email) {
        this.credential.setEmail(email);
        notifyObservers();
    }

    public Credential getCredential() {
        return credential;
    }

    public void setPassword(String password) {
        this.credential.setPassword(password);
        notifyObservers();
    }

    @Override
    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase phase) {
        this.currentPhase = phase;
        notifyObservers();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Credential getCredentials() {
        return credential;
    }

    @Override
    public void notifyObservers() {
        for (LoginObserver o : observerList) {
            o.update(this);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    @Override
    public void registerObserver(LoginObserver observer) {
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }

    public void clearMessage() {
        this.setMessage("");
    }

    /**
     * Login phases
     */
    public enum Phase {EMAIL, PASSWORD}

}
