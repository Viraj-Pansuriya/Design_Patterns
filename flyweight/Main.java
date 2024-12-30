import Model.IRobot;
import Model.Robot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        * Explanation :
        *
        * 1) Robot : for each new robot , it loads heavy image byte array (as of new we have just manually assigned memory)
        *
        * 2) IRobot : it use flyweight pattern to reuse objects from cache
        *
        * --> here I have added object into list , that's why it will be in use
        * --> otherwise garbage collector will remove it ,
        *      and we don't clear picture that simple object is taking more heap memory than IRobot (flyweight pattern)
        *
        * --> now once you run a loop for (1000*1000) times you will get heap memory error (Java OutOfMemory Exception)
        * --> for same IRobot thing , it won't give any error
        *
        * --> (list i have used just to prove flyweight pattern).
        *
        *
        * */

        List<Robot> robots = new ArrayList<>();
        List<IRobot> iRobots = new ArrayList<>();
        long start = System.currentTimeMillis();
        // With Flyweight: Reuse objects from cache
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
//                Robot robot = new Robot(i, j, "HUMAN");
//                robots.add(robot);
                IRobot robot = RobotCache.getRobot("HUMAN"); // Reuse object from cache (Flyweight)
                iRobots.add(robot);
            }
        }



        long end = System.currentTimeMillis();
        System.out.println("Time taken with Flyweight: " + (end - start) + " ms");
    }
}
