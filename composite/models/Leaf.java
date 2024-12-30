package models;

public class Leaf implements Component {

    String name ;
    String cost;

    public Leaf(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public int execute() {
        System.out.println("Leaf: " + name + " cost: " + cost);
        return Integer.parseInt(cost);
    }
}
