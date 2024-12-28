package ocjp_cerification_concepts.inheritance.features;

// The super keyword in Java is used to refer to the immediate parent class's methods and variables.
// It can be particularly useful in the context of method overriding, where you want to call a method from the parent class while also adding additional functionality in the child class.

// super keyword can be used in
//	1. Accessing Parent Class Members
//  2. Calling Parent Class Constructor
//  3. Shadowed Variables
class Parent {
    void display1() {
        System.out.println("Parent class display method");
    }

    private void cannotCallOutsideParentClass(){
        System.out.println("HEHEHEHE");
    }

    static void staticMethod() {
        System.out.println("Parent static method");
    }

    void instanceMethod() {
        System.out.println("Parent instance method");
    }

    private void privateMethod() {
        System.out.println("Parent private method");
    }

    void callPrivateMethod() {
        privateMethod(); // Accessible within the parent class
    }

    public String name = "Hari";

    public String company = "cacib";

}

class Child extends Parent {

    public String name = "Goutham"; //This hides the parent variable

    public String printParentHiddenVariable(){
        return super.name; //Shadowed Variables access with same name
    }
    Child(){
        super();// Calling Parent Class Constructor
    }
    @Override
    void display1() {
        super.display1(); // Call Parent's display method
        //super.cannotCallOutsideParentClass();
        //cannot call private method even with super keyword
        // 'cannotCallOutsideParentClass()' has private access in 'ocjp_cerification_concepts.inheritance.features.Parent'
        System.out.println("Child class display method");
    }

    static void staticMethod() {
        System.out.println("Child static method");
    }

    void instanceMethod() {
        System.out.println("Child instance method");
    }

    void display() {
        // Accessing the overridden instance method
        super.instanceMethod(); // Calls Parent's instance method
        this.instanceMethod();   // Calls Child's instance method

        // Accessing the private method through a public method in Parent
        callPrivateMethod(); // Calls Parent's private method indirectly

        // Attempting to access the static method using super (will cause a compile-time error)
        // super.staticMethod(); // Uncommenting this line will cause a compile-time error

        // Accessing the static method directly
        Child.staticMethod(); // Calls Child's static method
        Parent.staticMethod(); // Calls Parent's static method
    }
}

//    Accessing Parent Class Methods: You can use super to call a method from the parent class that has been overridden in the child class.
//    Accessing Parent Class Variables: You can use super to access a variable from the parent class if there is a variable with the same name in the child class.
//    Static Context: You cannot use super to access static methods or variables.
//    Static methods belong to the class, not to instances, and thus cannot be overridden in the same way instance methods can.
//    In Static Methods: You cannot use super in a static method because static methods do not have access to instance variables or methods.
//    Outside of Instance Context: You cannot use super in a static context or outside of an instance method or constructor


public class SuperKeyword {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
        System.out.println(child.name);//From child
        System.out.println(child.printParentHiddenVariable());//From parent
        Parent pr = new Child();
        System.out.println(pr.company);// Accessing Parent Class Members

    }
}

//Accessible:
//        Instance methods of the parent class (if overridden).
//        Instance variables of the parent class (if shadowed by child class variables).
//Not Accessible:
//        Static methods of the parent class.
//        Private methods and variables of the parent class (cannot be accessed directly, but can be accessed through public/protected methods).
//        Constructors of the parent class (you cannot call a parent constructor using super in a static context).

