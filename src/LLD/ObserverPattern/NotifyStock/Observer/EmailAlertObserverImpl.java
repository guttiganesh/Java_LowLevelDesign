package LLD.ObserverPattern.NotifyStock.Observer;

import LLD.ObserverPattern.NotifyStock.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId,"Product is in Stock");
    }

    private void sendEmail(String emailId, String productIsInStock) {
        System.out.println("mail sent to: "+emailId);
        //Send Actual mail to End USer
    }
}
