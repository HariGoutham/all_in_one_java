package ocjp_cerification_concepts.enumerations;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Enumeration {

    // 1. Basics of Enumerations in Java
    // 1.1 Definition of Enums
    // Enumerations (enum) are a special type in Java used to define collections of constants.
    // Enums are implicitly final and extend java.lang.Enum.

    // 1.2 Enum Syntax
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // 1.3 Key Characteristics
    // Enum constants are static and final.
    // Each constant is an instance of the enum type.

    // 2. Declaration and Usage
    // 2.1 Declaring an Enum
    // Define an enum inside or outside a class.
    // Enum constants are separated by commas.

    // 2.2 Using Enums
    public static void printDays() {
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }

    // 3. Enum as a Type
    // 3.1 Assigning Enum Values
    public static void assignEnumValue() {
        Day today = Day.FRIDAY;
        System.out.println("Today is: " + today);
    }

    // 3.2 Passing Enums as Parameters
    public static void printDay(Day day) {
        System.out.println(day);
    }

    // 4. Methods in Enums
    // 4.1 Predefined Methods in java.lang.Enum
    public static void enumMethods() {
        System.out.println("All days: " + Day.values());
        System.out.println("Enum constant for 'FRIDAY': " + Day.valueOf("FRIDAY"));
        System.out.println("Ordinal of 'MONDAY': " + Day.MONDAY.ordinal());
    }

    // 4.2 Overriding Methods in Enums
    public enum CustomDay {
        MONDAY, TUESDAY;

        @Override
        public String toString() {
            return "Day: " + super.toString();
        }
    }

    // 5. Adding Fields and Methods to Enums
    public enum DetailedDay {
        MONDAY("Start of the week"), FRIDAY("End of the week");

        private String description;

        private DetailedDay(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // 6. Enum with Switch Statement
    public static void switchExample(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Start of the week");
                break;
            case FRIDAY:
                System.out.println("End of the week");
                break;
            default:
                System.out.println("Another day");
        }
    }

    // 7. Enum and Interfaces
    public interface Greeting {
        void sayHello();
    }

    public enum GreetingDay implements Greeting {
        MONDAY {
            @Override
            public void sayHello() {
                System.out.println("Hello, Monday!");
            }
        }
    }

    // 8. Enum with Collections
    public static void collectionsExample() {
        Map<Day, String> dayMap = new HashMap<>();
        dayMap.put(Day.MONDAY, "Workday");
        System.out.println(dayMap.get(Day.MONDAY));

        EnumSet<Day> weekends = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekends: " + weekends);
    }

    // 9. Advanced Enum Features
    public enum Operation {
        ADD {
            @Override
            public int apply(int x, int y) {
                return x + y;
            }
        },
        SUBTRACT {
            @Override
            public int apply(int x, int y) {
                return x - y;
            }
        };

        public abstract int apply(int x, int y);
    }

    // 10. Nested Enums
    public static class OuterClass {
        public enum Color {
            RED, GREEN, BLUE;
        }
    }

    // 11. Enum Annotations
    // Enums can have annotations for metadata.
    // Example: @Deprecated, @Override, etc.

    // 12. Common Pitfalls and Exam Traps
    // 12.1 Invalid Enum Usage
    // Trying to create an instance of an enum using new.
    // Using an invalid string with valueOf().

    // 12.2 Switch-Case Mistakes
    // Forgetting to include a default case.

    // 12.3 Constructor Visibility
    // Enum constructors must be private or default.

    // 12.4 Understanding ordinal() Output
    // Relies on declaration order; changes can break logic relying on ordinal().

    // 13. Exam-Oriented Practice Topics
    // 13.1 Recognizing valid and invalid enum declarations.
    // 13.2 Writing and interpreting custom enums with fields and methods.
    // 13.3 Using enums in switch statements.
    // 13.4 Implementing abstract methods or interfaces in enums.
    // 13.5 Working with EnumSet and EnumMap.

    // Tricky Examination Questions
    // 1. What will happen if you try to create an instance of an enum using the 'new' keyword?
    // 2. Given the following code, what will be the output?
    //    enum Color { RED, GREEN, BLUE; }
    //    System.out.println(Color.valueOf("GREEN")); // Output?
    // 3. If you change the order of enum constants in an enum, how will it affect the output of the ordinal() method?
    // 4. Can an enum implement multiple interfaces? Provide an example.
    // 5. What is the difference between EnumSet and EnumMap? When would you use each?

    public static void main(String[] args) {
        printDays();
        assignEnumValue();
        printDay(Day.WEDNESDAY);
        enumMethods();
        System.out.println(DetailedDay.MONDAY.getDescription());
        switchExample(Day.FRIDAY);
        GreetingDay.MONDAY.sayHello();
        collectionsExample();
        System.out.println("Addition result: " + Operation.ADD.apply(5, 3));
        System.out.println("Color: " + OuterClass.Color.RED);
    }
}