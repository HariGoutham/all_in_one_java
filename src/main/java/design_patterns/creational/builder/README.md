# Builder Pattern in Java

## Overview

The Builder Pattern is a creational design pattern that allows for the step-by-step construction of complex objects. It provides a clear and readable way to create objects with many parameters, especially when some parameters are optional.

### Real-World Analogy

Think of building a sandwich. You can choose the type of bread, add various fillings, and select condiments. Each step is independent, allowing you to customize your sandwich as you like. This is similar to how the Builder Pattern allows for the step-by-step construction of objects.

## Problem Solved

The Builder Pattern addresses several issues:

- **Complex Object Construction**: Simplifies the creation of objects with many parameters.
- **Immutable Objects**: Facilitates the creation of immutable objects.
- **Readability and Clarity**: Improves code readability through a fluent interface.
- **Encapsulation of Construction Logic**: Separates construction logic from the object itself.
- **Flexibility**: Allows for different configurations without multiple constructors.
- **Avoiding Constructor Overloading**: Reduces confusion from overloaded constructors.

## Example: NutritionFacts Class

Here’s an example implementation of the Builder Pattern in Java for a `NutritionFacts` class.

### NutritionFacts Class Code

```java
public class NutritionFacts {
    private final int servingSize;  // (mL)
    private final int servings;      // (per container)
    private final int calories;      // (per serving)
    private final int fat;           // (g/serving)
    private final int sodium;        // (mg/serving)
    private final int carbohydrate;  // (g/serving)

    public static class Builder {
        // Required parameters
        private final int servingSize;  // (mL)
        private final int servings;      // (per container)

        // Optional parameters - initialized to default values
        private int calories     = 0;  // (per serving)
        private int fat          = 0;  // (g/serving)
        private int sodium       = 0;  // (mg/serving)
        private int carbohydrate = 0;  // (g/serving)

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}