package ocjp_cerification_concepts.inheritance;

//Explanation of Concepts

//Inheritance:
//        Defines an "is-a" relationship.
//        The Car class extends the Vehicle class, inheriting its behavior (e.g., start() method).
//        Use when there is a strict hierarchical relationship (e.g., Car "is a" Vehicle).

//Composition:
//        Defines a "has-a" relationship.
//        The CarWithEngine class contains an instance of the Engine class.
//        This approach is more flexible, as the Engine class can be reused in other classes.
//        Use composition when the relationship is not strictly hierarchical (e.g., Car "has an" Engine).


// Using Inheritance: 'Car' is a type of 'Vehicle'
class Vehicle {
    private int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void start() {
        System.out.println("Vehicle is starting.");
    }
}

class Car extends Vehicle {
    private String model;

    public Car(int speed, String model) {
        super(speed); // Call parent class constructor
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Car " + model + " is starting.");
    }
}

// Using Composition: 'Car' has an 'Engine'
class Engine {
    private int horsepower;

    public Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void startEngine() {
        System.out.println("Engine with " + horsepower + " HP is starting.");
    }
}

class CarWithEngine {
    private String model;
    private Engine engine; // Composition: Car "has an" Engine

    public CarWithEngine(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void start() {
        System.out.println("Car " + model + " is starting.");
        engine.startEngine(); // Delegating engine start to the Engine class
    }
}

public class CompositionAndInheritance {
    public static void main(String[] args) {
        // Using Inheritance
        Car myCar = new Car(120, "Toyota");
        System.out.println("Car speed: " + myCar.getSpeed() + " km/h");
        myCar.start();

        // Using Composition
        Engine myEngine = new Engine(200);
        CarWithEngine composedCar = new CarWithEngine("Honda", myEngine);
        composedCar.start();
    }
}

