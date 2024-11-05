# Facade Design Pattern

## Table of Contents
1. [Introduction](#introduction)
2. [Purpose](#purpose)
3. [Structure](#structure)
4. [Implementation](#implementation)
5. [Use Cases](#use-cases)
6. [Advantages](#advantages)
7. [Disadvantages](#disadvantages)
8. [Best Practices](#best-practices)
9. [Related Patterns](#related-patterns)
10. [Example: Zomato Order System](#example-zomato-order-system)
11. [Conclusion](#conclusion)

## Introduction

The Facade design pattern is a structural pattern that provides a simplified interface to a complex subsystem of classes, library, or framework. It encapsulates a set of interfaces in a higher-level interface, making the subsystem easier to use.

## Purpose

The main purposes of the Facade pattern are:
1. To provide a simple, easy-to-understand interface to a complex subsystem.
2. To reduce dependencies of outside code on the inner workings of a subsystem.
3. To layer the subsystems and provide a unified interface for a layer.

## Structure

The Facade pattern consists of these key components:

1. **Facade**: Provides a simple interface to the complex subsystem.
2. **Subsystem classes**: Implement subsystem functionality and handle work assigned by the Facade object.
3. **Client**: Uses the Facade instead of calling the subsystem objects directly.

## Implementation

Here's a basic implementation structure:

```java
// Facade
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    public void operation() {
        subsystemA.operationA();
        subsystemB.operationB();
        subsystemC.operationC();
    }
}

// Subsystem classes
class SubsystemA {
    public void operationA() { /* ... */ }
}

class SubsystemB {
    public void operationB() { /* ... */ }
}

class SubsystemC {
    public void operationC() { /* ... */ }
}

// Client
class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation();
    }
}
```

## Use Cases

The Facade pattern is useful in the following scenarios:

1. When you need to provide a simple interface to a complex subsystem.
2. When there are many dependencies between clients and the implementation classes of an abstraction.
3. When you want to layer your subsystems.
4. When you need to decouple your client implementation from any one subsystem.

## Advantages

1. **Simplification**: It shields clients from subsystem components, reducing the number of objects clients deal with.
2. **Decoupling**: It promotes weak coupling between the subsystem and its clients.
3. **Layering**: It helps to structure a system into layers.
4. **Flexibility**: Changes to the subsystem don't affect the clients.

## Disadvantages

1. **Limited Functionality**: The facade may become a "god object" coupled to all classes of an app.
2. **Performance Overhead**: Can introduce a slight performance overhead if the facade performs unnecessary operations.
3. **Violation of Open/Closed Principle**: The facade might need to be changed when the subsystem changes.

## Best Practices

1. **Keep it Simple**: The Facade should manage dependencies and provide a simple interface without adding new functionality.
2. **Don't Force It**: Use a facade only when you need to simplify a complex subsystem.
3. **Consider Multiple Facades**: For very complex systems, consider using multiple facades for different use cases.
4. **Avoid Overuse**: Don't use facades where simple interfaces already exist.
5. **Maintain Independence**: Ensure that the facade doesn't become tightly coupled to the subsystem.

## Related Patterns

1. **Abstract Factory**: Can be used with Facade to provide an interface for creating subsystem objects.
2. **Adapter**: Is often used with Facade when a simpler interface to an existing system is required.
3. **Mediator**: Is similar to Facade in that it abstracts functionality of existing classes, but Mediator centralizes communication between objects.
4. **Singleton**: The Facade object is often implemented as a Singleton.

## Example: Zomato Order System

Let's examine a real-world example of the Facade pattern using a simplified Zomato order system:

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        ZomatoFacade zomatoFacade = new ZomatoFacade();
        zomatoFacade.placeOrder();
    }
}

// ZomatoFacade.java
public class ZomatoFacade {
    private DeliveryBoy deliveryBoy;
    private DeliveryTeam deliveryTeam;
    private Restaurant restaurant;

    public ZomatoFacade() {
        this.deliveryBoy = new DeliveryBoy();
        this.deliveryTeam = new DeliveryTeam();
        this.restaurant = new Restaurant();
    }

    public void placeOrder() {
        restaurant.prepareFood();
        deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickUpFood();
        deliveryBoy.deliverFood();
    }
}

// Restaurant.java
public class Restaurant {
    public void prepareFood() {
        System.out.println("Food is being prepared");
    }
}

// DeliveryTeam.java
public class DeliveryTeam {
    public void assignDeliveryBoy() {
        System.out.println("Delivery Guy is being assigned");
    }
}

// DeliveryBoy.java
public class DeliveryBoy {
    public void pickUpFood() {
        System.out.println("Food is being picked up");
    }

    public void deliverFood() {
        System.out.println("Food is being delivered");
    }
}
```

In this example:

1. `ZomatoFacade` is the Facade class that provides a simple `placeOrder()` method to the client.
2. `Restaurant`, `DeliveryTeam`, and `DeliveryBoy` are the subsystem classes.
3. The `Main` class acts as the client, using the Facade to place an order.

The Facade pattern simplifies the process of placing an order by encapsulating the complexities of food preparation, delivery assignment, and food delivery behind a single method call.

## Conclusion

The Facade design pattern is a powerful tool for simplifying complex systems and providing a clean, easy-to-use interface for clients. It's particularly useful in scenarios where you need to integrate complex subsystems or provide a simplified view of a larger system. While it can introduce some limitations in terms of flexibility, when used appropriately, it can significantly improve the overall structure and maintainability of your code. Understanding when and how to apply the Facade pattern is a valuable skill for any developer working on complex systems or integrating multiple subsystems.