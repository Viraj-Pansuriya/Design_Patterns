package Model;

public class Notification implements Notify {
    @Override
    public void notifyUser() {
        System.out.println("Notifying user via Email");
    }
}
