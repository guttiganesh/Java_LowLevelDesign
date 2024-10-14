package LLD.ObserverPattern.NotifyStock;

import LLD.ObserverPattern.NotifyStock.Observable.IphoneObservableImpl;
import LLD.ObserverPattern.NotifyStock.Observable.StockObservable;
import LLD.ObserverPattern.NotifyStock.Observer.EmailAlertObserverImpl;
import LLD.ObserverPattern.NotifyStock.Observer.MobileAlertObserverImpl;
import LLD.ObserverPattern.NotifyStock.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args){
        StockObservable iphoneObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("Arun13@gmail.com",iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("Amit14@gmail.com",iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("9840586921",iphoneObservable);
        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);
        iphoneObservable.setStockCount(10);

    }
}
