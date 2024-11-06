# Flyweight Design Pattern

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
12. [Example: Shape Drawing Application](#example-shape-drawing-application)
13. [Conclusion](#conclusion)

## Introduction

The Flyweight design pattern is a structural pattern that aims to minimize memory usage or computational expenses by sharing as much as possible with similar objects. It's particularly useful when dealing with a large number of objects that have some shared state.

## Definition

The Flyweight pattern uses sharing to support large numbers of fine-grained objects efficiently. A flyweight is a shared object that can be used in multiple contexts simultaneously. The pattern divides an object's state into intrinsic and extrinsic parts.

## Components

The Flyweight pattern consists of these key components:

1. **Flyweight**: Declares an interface through which flyweights can receive and act on extrinsic state.
2. **ConcreteFlyweight**: Implements the Flyweight interface and adds storage for intrinsic state.
3. **UnsharedConcreteFlyweight**: Not all Flyweight subclasses need to be shared.
4. **FlyweightFactory**: Creates and manages flyweight objects.
5. **Client**: Maintains a reference to flyweight(s) and computes or stores the extrinsic state of flyweight(s).

## Purpose

The main purposes of the Flyweight pattern are:
1. To reduce memory usage when a program needs a huge number of similar objects.
2. To reduce the total number of instances created by sharing objects.
3. To provide a way to use objects in fine granularity without incurring high costs.

## Structure

Here's a basic structure of the Flyweight pattern:

```
Client --> FlyweightFactory
             |
             v
          Flyweight <---- ConcreteFlyweight
                     <---- UnsharedConcreteFlyweight
```

## Implementation

Here's a basic implementation structure:

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight
interface Flyweight {
    void operation(String extrinsicState);
}

// ConcreteFlyweight
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Intrinsic State = " + intrinsicState);
        System.out.println("Extrinsic State = " + extrinsicState);
    }
}

// FlyweightFactory
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fw1 = factory.getFlyweight("Key1");
        Flyweight fw2 = factory.getFlyweight("Key2");
        Flyweight fw3 = factory.getFlyweight("Key1");

        fw1.operation("ExState1");
        fw2.operation("ExState2");
        fw3.operation("ExState3");
    }
}
```

## Use Cases

The Flyweight pattern is useful in the following scenarios:

1. When an application uses a large number of objects.
2. When storage costs are high because of the sheer quantity of objects.
3. When most object state can be made extrinsic.
4. When many groups of objects may be replaced by relatively few shared objects once extrinsic state is removed.
5. In text editors or word processors for character representation.
6. In game development for representing particles or other numerous similar objects.

## Advantages

1. **Reduced memory usage**: By sharing common parts of state between multiple objects.
2. **Improved performance**: Fewer object creations can lead to better performance.
3. **Increased flexibility**: Extrinsic state can be computed or stored by client objects.
4. **Scalability**: Supports a large number of fine-grained objects efficiently.

## Disadvantages

1. **Increased complexity**: The pattern can make the code more complex and harder to understand.
2. **Potential for errors**: If not implemented correctly, it can lead to errors related to shared state.
3. **Performance trade-off**: In some cases, the cost of transferring extrinsic state can outweigh the benefits.
4. **Debugging challenges**: Shared objects can make debugging more difficult.

## Best Practices

1. **Identify shared state**: Carefully identify which state can be shared (intrinsic) and which cannot (extrinsic).
2. **Immutable shared objects**: Make shared flyweight objects immutable to prevent issues with shared state.
3. **Use a factory**: Implement a factory to manage the creation and caching of flyweight objects.
4. **Consider thread safety**: If your application is multi-threaded, ensure that the flyweight factory is thread-safe.
5. **Balance trade-offs**: Consider the trade-off between memory savings and runtime costs when deciding to use flyweights.
6. **Document clearly**: Clearly document which parts of your objects are intrinsic and extrinsic.

## Related Patterns

1. **Composite**: Flyweight is often combined with Composite to implement a shared leaf node.
2. **State**: Flyweight explains when and how State objects can be shared.
3. **Strategy**: Flyweight is similar to Strategy in that both patterns involve many fine-grained objects.
4. **Singleton**: The Flyweight Factory is often implemented as a Singleton.

## Example: Shape Drawing Application

Let's examine a real-world example of the Flyweight pattern using a shape drawing application:

```java
// Shape.java (Flyweight)
import java.awt.Color;
import java.awt.Graphics;

public interface Shape {
    public void draw(Graphics g, int x, int y, int width, int height, Color color);
}

// Oval.java (ConcreteFlyweight)
import java.awt.Color;
import java.awt.Graphics;

public class Oval implements Shape {
    private boolean isFilled;

    public Oval(boolean isFilled) {
        this.isFilled = isFilled;
        if (isFilled) {
            System.out.println("Creating a filled oval");
        } else {
            System.out.println("Creating an oval");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void draw(Graphics oval, int x, int y, int width, int height, Color color) {
        oval.setColor(color);
        oval.drawOval(x, y, width, height);
        if (isFilled) {
            oval.fillOval(x, y, width, height);
        }
    }
}

// Line.java (ConcreteFlyweight)
import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape {
    public Line() {
        System.out.println("Line object created");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
    
    @Override
    public void draw(Graphics line, int x1, int y1, int x2, int y2, Color color) {
        line.setColor(color);
        line.drawLine(x1, y1, x2, y2);
    }
}

// ShapeFactory.java (FlyweightFactory)
import java.util.HashMap;

public class ShapeFactory {
    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);
        if (shapeImpl == null) {
            shapeImpl = switch (type) {
                case OVAL_FILL -> new Oval(true);
                case OVAL_NOFILL -> new Oval(false);
                case LINE -> new Line();
            };
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public static enum ShapeType {
        OVAL_FILL, OVAL_NOFILL, LINE;
    }
}

// Main.java (Client)
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ShapeFactory.getShape(ShapeFactory.ShapeType.OVAL_FILL).draw(g, 10, 10, 100, 50, Color.decode("#FF0000")); // Red
        ShapeFactory.getShape(ShapeFactory.ShapeType.OVAL_NOFILL).draw(g, 120, 10, 100, 50, Color.GREEN); // Green
        ShapeFactory.getShape(ShapeFactory.ShapeType.LINE).draw(g, 10, 70, 120, 70, Color.BLUE); // Blue
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Drawer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
```

In this example:

1. `Shape` is the Flyweight interface.
2. `Oval` and `Line` are ConcreteFlyweight classes.
3. `ShapeFactory` is the FlyweightFactory.
4. `Main` acts as the Client, creating and using the flyweight objects.

This structure allows the application to efficiently create and manage a large number of shape objects. The intrinsic state (shape type and whether it's filled) is stored in the flyweight objects, while the extrinsic state (position, size, color) is passed in by the client when drawing.

## Conclusion

The Flyweight design pattern is a powerful tool for optimizing memory usage in applications that deal with a large number of similar objects. It's particularly useful in scenarios where the cost of creating objects is high and the objects can share a significant amount of data. While it can introduce some complexity, when used appropriately, it can significantly improve the efficiency and scalability of your application. Understanding when and how to apply the Flyweight pattern is a valuable skill for any developer working on systems with memory constraints or dealing with large numbers of similar objects.