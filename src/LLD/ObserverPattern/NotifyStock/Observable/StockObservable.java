package LLD.ObserverPattern.NotifyStock.Observable;

import LLD.ObserverPattern.NotifyStock.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int stock);
    public int getStockCount();

}
