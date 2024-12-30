import Model.DogRobot;
import Model.HumanRobot;
import Model.IRobot;

import java.util.HashMap;
import java.util.Map;

public class RobotCache {
    private static Map<String , IRobot> robotCache = new HashMap<>() ;

    public static IRobot getRobot(String type){
        if(robotCache.containsKey(type)){
            return robotCache.get(type);
        }
        if(type.equals("HUMAN")) {
            robotCache.put(type , new HumanRobot());
        }
        else{
            robotCache.put(type , new DogRobot());
        }
        return robotCache.get(type);
    }
}
