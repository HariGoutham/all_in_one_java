package java_interview;

/**
 * Comprehensive Object-Oriented Programming Concepts Demonstration
 *
 * Concepts Covered:
 * 1. Inheritance
 *    - Hierarchical class structure
 *    - Abstract base class
 *    - Subclass implementation
 *
 * 2. Composition
 *    - "Has-a" relationship
 *    - Embedding objects within classes
 *    - Modular design
 *
 * 3. Encapsulation
 *    - Private fields
 *    - Controlled access through getters/setters
 *    - Data hiding
 *
 * 4. Polymorphism
 *    - Method overriding
 *    - Runtime polymorphism
 *    - Abstract method implementation
 *
 * 5. Additional Concepts
 *    - Abstract classes
 *    - Constructor chaining
 *    - Type casting
 *    - Interface-like behavior
 *
 * Key Learning Objectives:
 * - Understand relationships between classes
 * - Implement flexible and extensible design
 * - Demonstrate core OOP principles
 */
public class Java4OOPConceptsDemonstration {
    // Abstract base class demonstrating inheritance and encapsulation
    abstract static class Vehicle {
        // Encapsulation: private fields with controlled access
        private String brand;
        private String model;
        protected double speed;

        // Constructor with parameter initialization
        public Vehicle(String brand, String model) {
            this.brand = brand;
            this.model = model;
            this.speed = 0;
        }

        // Encapsulation: Getters and Setters
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        // Abstract method (polymorphism)
        public abstract void accelerate();

        // Concrete method with default implementation
        public void displayInfo() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Current Speed: " + speed);
        }
    }

    // Composition demonstration class
    static class Engine {
        private String type;
        private int horsePower;

        // Comprehensive constructor
        public Engine(String type, int horsePower) {
            this.type = type;
            this.horsePower = horsePower;
        }

        // Engine-specific method
        public void start() {
            System.out.println("Engine started. Type: " + type + ", Power: " + horsePower + "HP");
        }
    }

    // Inheritance and Polymorphism: Car implementation
    static class Car extends Vehicle {
        // Composition: Car has an Engine
        private Engine engine;

        // Constructor using composition and super call
        public Car(String brand, String model, Engine engine) {
            super(brand, model);
            this.engine = engine;
        }

        // Polymorphic method implementation
        @Override
        public void accelerate() {
            speed += 10;
            System.out.println("Car accelerating. Current speed: " + speed);
        }

        // Composition-specific method
        public void startEngine() {
            engine.start();
        }
    }

    // Another inherited class demonstrating polymorphism
    static class Motorcycle extends Vehicle {
        private boolean hasSidecar;

        // Specialized constructor
        public Motorcycle(String brand, String model, boolean hasSidecar) {
            super(brand, model);
            this.hasSidecar = hasSidecar;
        }

        // Polymorphic method implementation
        @Override
        public void accelerate() {
            speed += 15;
            System.out.println("Motorcycle accelerating. Current speed: " + speed);
        }

        // Motorcycle-specific method
        public void checkSidecar() {
            System.out.println("Sidecar present: " + hasSidecar);
        }
    }

    // Main method to demonstrate OOP concepts
    public static void main(String[] args) {
        // Composition example
        Engine carEngine = new Engine("V6", 300);

        // Polymorphism: Creating objects of different types
        Vehicle car = new Car("Toyota", "Camry", carEngine);
        Vehicle motorcycle = new Motorcycle("Harley", "Sportster", false);

        // Demonstrating polymorphic behavior
        demonstratePolymorphism(car);
        demonstratePolymorphism(motorcycle);

        // Additional method calls with type checking
        if (car instanceof Car carInstance) {
            carInstance.startEngine();
        }

        if (motorcycle instanceof Motorcycle motoInstance) {
            motoInstance.checkSidecar();
        }
    }

    // Polymorphic method that works with different Vehicle types
    public static void demonstratePolymorphism(Vehicle vehicle) {
        // Displaying information (method from base class)
        vehicle.displayInfo();

        // Calling polymorphic method
        vehicle.accelerate();
        vehicle.accelerate();

        // Demonstrating runtime polymorphism
        System.out.println("Vehicle type: " + vehicle.getClass().getSimpleName());
        System.out.println("---");
    }
}
