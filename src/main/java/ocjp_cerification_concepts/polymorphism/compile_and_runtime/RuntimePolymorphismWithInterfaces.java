package ocjp_cerification_concepts.polymorphism.compile_and_runtime;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class RuntimePolymorphismWithInterfaces {
    public static void main(String[] args) {
        Shape shape = new Circle(); // Circle is a Shape
        shape.draw(); // Outputs: Drawing Circle
        shape = new Square(); // Now shape is a Square
        shape.draw(); // Outputs: Drawing Square
    }
}
