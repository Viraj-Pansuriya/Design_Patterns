interface Shape {
    Shape clone();  // Make a copy of itself
    void draw();    // Draw the shape
}

// Client code
class ShapeClient {
    private Shape shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using the prototype.
    public Shape createShape() {
        return shapePrototype.clone();
    }
}

// Concrete prototype with costly initialization
class Circle implements Shape, Cloneable {
    private String color;

    public Circle(String color) {
        // Simulate expensive initialization
        System.out.println("Simulating expensive object creation for a " + color + " circle...");
        try {
            Thread.sleep(10000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.color = color;
    }

    @Override
    public Shape clone() {
        System.out.println("Cloning the " + color + " circle...");
        try {
            return (Circle) super.clone(); // Use native cloning
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should never happen
        }
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

// Main class
public class PrototypeExample {
    public static void main(String[] args) {
        System.out.println("Creating the prototype...");
        Shape circlePrototype = new Circle("red");

        System.out.println("\nUsing the prototype to create new objects...");
        ShapeClient client = new ShapeClient(circlePrototype);

        // Clone the prototype to create multiple objects
        Shape redCircle1 = client.createShape(); // No delay here
        redCircle1.draw();

        Shape redCircle2 = client.createShape(); // No delay here
        redCircle2.draw();
    }
}
