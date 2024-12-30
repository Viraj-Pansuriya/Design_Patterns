package Model;

public class FacebookNotification extends WrapperNotification {
    public FacebookNotification(Notify notify) {
        super(notify);
    }

    @Override
    public void notifyUser() {
        System.out.println("Notifying user via Facebook");
        super.notifyUser();
    }
}
