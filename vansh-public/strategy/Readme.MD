# Strategy Design Pattern

## Table of Contents
1. [Introduction](#introduction)
2. [Definition](#definition)
3. [Components](#components)
4. [Purpose](#purpose)
5. [Structure](#structure)
6. [Implementation](#implementation)
7. [Use Cases](#use-cases)
8. [Advantages](#advantages)
9. [Disadvantages](#disadvantages)
10. [Best Practices](#best-practices)
11. [Related Patterns](#related-patterns)
12. [Example: Simple Calculator](#example-simple-calculator)
13. [Conclusion](#conclusion)

## Introduction

The Strategy design pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

## Definition

The Strategy pattern allows you to define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Components

The Strategy pattern consists of these key components:

1. **Strategy**: This is an interface common to all supported algorithms. Context uses this interface to call the algorithm defined by a ConcreteStrategy.
2. **ConcreteStrategy**: These are classes that implement the Strategy interface, providing different variations of an algorithm.
3. **Context**: This is a class that uses a Strategy. It maintains a reference to a Strategy object and may define an interface that lets Strategy access its data.

## Purpose

The main purposes of the Strategy pattern are:
1. To define a family of algorithms, encapsulate each one, and make them interchangeable.
2. To allow the algorithm to vary independently from clients that use it.
3. To eliminate large conditional statements.
4. To provide a way to configure a class with one of many behaviors.

## Structure

Here's a basic structure of the Strategy pattern:

```
Client --> Context
             |
             v
           Strategy <---- ConcreteStrategyA
                    <---- ConcreteStrategyB
                    <---- ConcreteStrategyC
```

## Implementation

Here's a basic implementation structure:

```java
// Strategy interface
interface Strategy {
    int execute(int a, int b);
}

// Concrete strategies
class ConcreteStrategyA implements Strategy {
    public int execute(int a, int b) {
        return a + b;  // Addition
    }
}

class ConcreteStrategyB implements Strategy {
    public int execute(int a, int b) {
        return a - b;  // Subtraction
    }
}

// Context
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new ConcreteStrategyB());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}
```

## Use Cases

The Strategy pattern is useful in the following scenarios:

1. When you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
2. When you have many related classes that differ only in their behavior.
3. When you need different variations of an algorithm.
4. To isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
5. When a class defines many behaviors, and these appear as multiple conditional statements in its operations.

## Advantages

1. **Flexibility**: You can easily switch between different algorithms (strategies) in runtime.
2. **Reusability**: Strategies can be reused across different contexts.
3. **Open/Closed Principle**: You can introduce new strategies without having to change the context.
4. **Separation of Concerns**: The algorithms are separated from the context, promoting single responsibility.
5. **Eliminates conditional statements**: Removes the need for complex conditional statements.

## Disadvantages

1. **Increased number of objects**: The pattern increases the number of objects in an application.
2. **Awareness of different strategies**: Clients must be aware of different strategies and their differences.
3. **Communication overhead**: Strategy and Context interfaces may be bloated if they're sharing application-wide strategy.
4. **Increased complexity**: For simple cases, it might introduce unnecessary complexity.

## Best Practices

1. **Use when variation in behavior is required**: Use the Strategy pattern when you need different variations of an algorithm.
2. **Consider static strategies**: If a strategy doesn't maintain state, consider making it static.
3. **Use composition over inheritance**: Strategy uses composition, which is often preferable to inheritance for sharing behavior.
4. **Keep the Strategy interface lean**: Only include methods in the Strategy interface that all concrete strategies share.
5. **Consider using lambda expressions**: In languages that support lambda expressions, you can often use them instead of creating separate strategy classes.
6. **Use dependency injection**: Consider using dependency injection to provide strategies to the context.

## Related Patterns

1. **State**: Like Strategy, the State pattern allows an object to change its behavior. The main difference is that in State, the states are aware of each other and an object can change its state on its own, while in Strategy, the strategies are usually independent.
2. **Bridge**: The Bridge pattern is similar to Strategy in that it separates an abstraction from its implementation.
3. **Template Method**: Template Method uses inheritance to vary part of an algorithm. Strategy uses delegation to vary the entire algorithm.
4. **Decorator**: Decorator lets you change the skin of an object, while Strategy lets you change the guts.

## Example: Simple Calculator

Let's examine a real-world example of the Strategy pattern using a simple calculator:

```java
// Strategy.java
public interface Strategy {
    public int doOperation(int num1, int num2);
}

// AddStrategy.java
public class AddStrategy implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

// SubtractStrategy.java
public class SubtractStrategy implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

// MultiplyStrategy.java
public class MultiplyStrategy implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

// Context.java
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        
        context = new Context(new SubtractStrategy());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        
        context = new Context(new MultiplyStrategy());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
```

In this example:

1. `Strategy` is the interface that all concrete strategies implement.
2. `AddStrategy`, `SubtractStrategy`, and `MultiplyStrategy` are concrete implementations of the Strategy interface.
3. `Context` is the class that uses a Strategy.
4. `Main` acts as the client, demonstrating how to use the Strategy pattern to perform different arithmetic operations.

This structure allows the calculator to easily switch between different arithmetic operations without changing its core logic. New operations can be added by creating new strategy classes without modifying existing code.

## Conclusion

The Strategy design pattern is a powerful tool for managing algorithms, relationships, and responsibilities between objects. It's particularly useful in scenarios where you need to dynamically change the algorithm used by an object at runtime. While it can introduce some complexity for simple cases, when used appropriately, it can significantly improve the flexibility, maintainability, and scalability of your code. Understanding when and how to apply the Strategy pattern is a valuable skill for developers working on systems that require dynamic algorithm selection or behavior modification.