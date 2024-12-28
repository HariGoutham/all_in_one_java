package ocjp_cerification_concepts.inheritance.main;


//	      Inheritance Definition:
//        ○ The process by which one class acquires the properties and behaviors of another class.
//        ○ Enables reusability and establishes a parent-child relationship.

//        Key Concepts:
//        Parent Class (Super Class): The class being inherited.
//        Child Class (Sub Class): The class inheriting from another(uses extends Keyword).
//        Java does not support multiple inheritance through classes (to avoid ambiguity)

class Parent {
    int value = 10;

    void display() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    int value = 20; // Overrides value in Parent

    @Override
    void display() {
        System.out.println("Child class method");
    }
}

public class Main {

    public static void main(String[] args) {
        Parent p = new Parent();
        p.display();

        Parent c = new Child();
        c.display();//overrides parent class, for methods , values are from objects not the reference types

        Child c1 = new Child();
        c1.display();

        int value = p.value;
        int value1 = c.value;// This value is from parent class, because for variables values are from reference types
        int value2 = c1.value;

        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);
    }
}
