package Model;

public class WrapperNotification implements Notify {
    private Notify notify;

    public WrapperNotification(Notify notify) {
        this.notify = notify;
    }

    @Override
    public void notifyUser() {
        notify.notifyUser();
    }
}
