package nello.model;

import nello.observable.LoginObservable;
import nello.observer.LoginObserver;

import java.util.ArrayList;
import java.util.List;

public class LoginModel implements LoginObservable {

    public enum Phase {EMAIL, PASSWORD}

    private ViewMessage errorMessage = ViewMessage.EMPTY_STRING;
    private List<LoginObserver> observerList = new ArrayList<>();
    private Credential credential = new Credential();
    private Phase currentPhase = Phase.EMAIL;

    private String authToken;

    public void registerObserver(LoginObserver observer) {
        observerList.add(observer);
    }

    public Credential getCredential() {
        return credential;
    }

    public void updateEmail(String email) {
        this.credential.setEmail(email);
        notifyObservers();
    }

    public void updatePassword(String password) {
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
    public ViewMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ViewMessage message) {
        this.errorMessage = message;
        notifyObservers();
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

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
