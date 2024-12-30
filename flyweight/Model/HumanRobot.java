package Model;

public class HumanRobot implements IRobot{

    private String type = "HUMAN";
    private byte[] image  = new byte[221*1024];

    @Override
    public void display(int x, int y) {
        System.out.println("Human Robot is at : " + x + " , " + y);
    }
}
