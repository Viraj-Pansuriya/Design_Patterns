package models;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private String name;
    private List<Component> children;

    public Composite(List<Component> children , String name) {
        this.name = name;
        this.children = children;
    }

    @Override
    public int  execute() {
        int sum =  children.stream().mapToInt(Component::execute).sum();
        System.out.println("For Container : " + name + " total cost is : " + sum);
        return sum;
//        int sum = 0;
//        for(Component c : children){
//            sum += c.execute();
//        }
//        return sum;
    }
}
