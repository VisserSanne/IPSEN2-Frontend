package nello.observer;

import nello.observable.TabObservable;

public interface TabObserver {
    void update(TabObservable o);
}
