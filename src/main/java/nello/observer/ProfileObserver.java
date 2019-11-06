package nello.observer;

import nello.observable.ProfileObservable;

public interface ProfileObserver {

    void update(ProfileObservable o);

}
