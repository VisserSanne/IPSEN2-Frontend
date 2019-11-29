package nello.model;

import nello.observable.TabObservable;
import nello.observer.TabObserver;

import java.util.ArrayList;
import java.util.List;

public class TabModel implements TabObservable {

    public List<TabObserver> observerList = new ArrayList<>();
    private String activeTab;
    private User[] userList;

    @Override
    public String getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (TabObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(TabObserver observer) {
        observerList.add(observer);
        observer.update(this);
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }
}
