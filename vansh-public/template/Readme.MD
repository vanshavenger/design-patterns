# Template Method Design Pattern

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
12. [Example: Game Framework](#example-game-framework)
13. [Conclusion](#conclusion)

## Introduction

The Template Method design pattern is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

## Definition

The Template Method pattern defines the program skeleton of an algorithm in an operation, deferring some steps to subclasses. It lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

## Components

The Template Method pattern consists of these key components:

1. **Abstract Class**: Defines abstract primitive operations that concrete subclasses define to implement steps of an algorithm. It implements a template method defining the skeleton of an algorithm.
2. **Concrete Class**: Implements the primitive operations to carry out subclass-specific steps of the algorithm.

## Purpose

The main purposes of the Template Method pattern are:
1. To implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary.
2. To factor out common behavior in subclasses.
3. To control subclasses extensions by defining a template method that calls "hook" operations at specific points, thereby permitting extensions only at those points.

## Structure

Here's a basic structure of the Template Method pattern:

```
AbstractClass
    |
    |--> templateMethod()
    |
    |--> primitiveOperation1()
    |
    |--> primitiveOperation2()
    |
    v
ConcreteClass
    |
    |--> primitiveOperation1()
    |
    |--> primitiveOperation2()
```

## Implementation

Here's a basic implementation structure:

```java
abstract class AbstractClass {
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
    }

    protected abstract void primitiveOperation1();
    protected abstract void primitiveOperation2();

    private void concreteOperation() {
        System.out.println("AbstractClass: concreteOperation");
    }
}

class ConcreteClass extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClass: primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClass: primitiveOperation2");
    }
}

public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
```

## Use Cases

The Template Method pattern is useful in the following scenarios:

1. When you want to implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary.
2. When common behavior among subclasses should be factored and localized in a common class to avoid code duplication.
3. To control subclass extensions by defining a template method that calls "hook" operations at specific points, thereby permitting extensions only at those points.
4. In frameworks, where the framework implements the invariant parts of an algorithm, and the user then implements the variant parts.

## Advantages

1. **Code reuse**: It promotes code reuse by providing a skeleton method in the base class.
2. **Flexibility**: Allows subclasses to override only certain parts of a large algorithm.
3. **Inversion of control**: The pattern provides a classic example of "inversion of control" or "the Hollywood principle" ("don't call us, we'll call you").
4. **Fine points of control**: Allows you to define "hooks" for subclasses to optionally override.

## Disadvantages

1. **Restricted to a single algorithm**: A template method defines a single, non-replaceable algorithm.
2. **Violation of Liskov Substitution Principle**: If the base class is not well designed, it might violate the Liskov Substitution Principle.
3. **Maintenance challenges**: As the algorithm grows more complex, maintaining the template method can become challenging.
4. **Limited flexibility**: The pattern can be less flexible than the Strategy pattern for changing algorithms at runtime.

## Best Practices

1. **Minimize abstract operations**: Try to minimize the number of abstract operations that a subclass must implement.
2. **Naming conventions**: Use naming conventions to identify which methods are hooks (may be overridden) and which are abstract operations (must be overridden).
3. **Document the algorithm**: Clearly document the steps of the algorithm and which steps can or must be overridden.
4. **Use final for the template method**: To prevent subclasses from changing the algorithm's structure, declare the template method as final.
5. **Consider using Strategy**: If you need more flexibility in changing algorithms at runtime, consider using the Strategy pattern instead.
6. **Use hooks wisely**: Provide sensible default implementations for hook methods where possible.

## Related Patterns

1. **Factory Method**: Often called by template methods.
2. **Strategy**: Template methods use inheritance to vary part of an algorithm. Strategies use delegation to vary the entire algorithm.
3. **Builder**: Can use a template method to implement the construction process.

## Example: Game Framework

Let's examine a real-world example of the Template Method pattern using a game framework:

```java
// Game.java (Abstract Class)
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play()  {
        initialize();
        startPlay();
        endPlay();
    } 
}

// Cricket.java (Concrete Class)
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

// Football.java (Concrete Class)
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

// Main.java (Client)
public class Main {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
```

In this example:

1. `Game` is the abstract class that defines the template method `play()` and the abstract methods that need to be implemented by concrete classes.
2. `Cricket` and `Football` are concrete classes that extend `Game` and provide specific implementations for the abstract methods.
3. `Main` acts as the client, demonstrating how to use the Template Method pattern to play different types of games.

This structure allows for easy addition of new game types without changing the overall game-playing algorithm. The `play()` method in the `Game` class defines the template for playing any game, while the specific steps are implemented in the subclasses.

## Conclusion

The Template Method design pattern is a powerful tool for defining the skeleton of an algorithm in a method, deferring some steps to subclasses. It's particularly useful in scenarios where you have a fixed series of steps in an algorithm, but the implementation of some steps may vary. While it can introduce some limitations in terms of runtime flexibility, when used appropriately, it can significantly improve code reuse and provide a clear structure for algorithms with variant and invariant parts. Understanding when and how to apply the Template Method pattern is a valuable skill for developers working on frameworks or systems with well-defined algorithmic structures that need to support multiple variations.