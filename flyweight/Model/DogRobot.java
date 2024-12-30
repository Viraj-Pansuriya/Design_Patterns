package Model;

public class DogRobot implements IRobot {

    private String type = "DOG";
    private byte[] image = new byte[21*1024];
    @Override
    public void display(int x, int y) {
        System.out.println("Dog Robot is at (" + x + "," + y + ")");
    }
}
