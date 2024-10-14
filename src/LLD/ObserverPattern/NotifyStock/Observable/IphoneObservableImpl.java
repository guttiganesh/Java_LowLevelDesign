package LLD.ObserverPattern.NotifyStock.Observable;

import LLD.ObserverPattern.NotifyStock.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    List<NotificationAlertObserver> observerList = new ArrayList<>();
    int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer:observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stock) {
        if(stockCount == 0) notifySubscribers();
        stockCount += stock;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
