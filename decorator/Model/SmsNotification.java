package Model;

public class SmsNotification extends WrapperNotification {


    public SmsNotification(Notify notify) {
        super(notify);
    }

    @Override
    public void notifyUser() {
        System.out.println("Notifying user via SMS");
        super.notifyUser();
    }
}
