import models.Component;
import models.Composite;
import models.Leaf;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Component milk = new Leaf("Milk", "10");
        Component tea = new Leaf("Tea", "20");
        Component coffee = new Leaf("Coffee", "30");
        Component water = new Leaf("Water", "40");



        Component biscuit = new Leaf("Biscuit", "50");
        Component cake = new Leaf("Cake", "60");

        Component container2 = new Composite(List.of(biscuit, cake) , "Bakery Items");


        List<Component> components = new ArrayList<>();
        components.add(container2);
        components.add(milk);
        components.add(tea);
        components.add(coffee);
        components.add(water);


        Component container = new Composite(components , "Outer Container");

        container.execute();


    }
}
