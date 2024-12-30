import Model.IRobot;
import Model.Robot;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        // With Flyweight: Reuse objects from cache
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                Robot robot = new Robot(i, j, "HUMAN");
//                IRobot robot = RobotCache.getRobot("HUMAN"); // Reuse object from cache (Flyweight)
//                robot.display(i, j);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken with Flyweight: " + (end - start) + " ms");
    }
}
