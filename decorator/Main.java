import Model.*;

public class Main {
    public static void main(String[] args) {

        Notify notify = new Notification();
//        notify.notifyUser();

        WrapperNotification wrapperNotification = new WrapperNotification(notify);
        wrapperNotification = new SmsNotification(wrapperNotification);
        wrapperNotification = new FacebookNotification(wrapperNotification);
        wrapperNotification.notifyUser();
    }
}
