package nello.observable;

public interface NetworkMemberObservable {
    long getId();

    void setId(long id);

    Boolean isBusiness();

    String getName();


    /**
     * Notifies all registered observers that there has been an update
     *
     * @author Valerie Timmerman
     */

    void notifyObservers();

    void registerObserver(NetworkMemberObservable observer);
}
