package LLD.ObserverPattern.NotifyStock.Observer;

import LLD.ObserverPattern.NotifyStock.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String mobileNo;
    StockObservable observable;

    public MobileAlertObserverImpl(String mobileNo, StockObservable observable) {
        this.mobileNo = mobileNo;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsg(mobileNo,"Product is in Stock");
    }

    private void sendMsg(String mobileNo, String productIsInStock) {
        System.out.println("sent msg to : "+mobileNo);
        //Send Actual message to End User
    }
}
