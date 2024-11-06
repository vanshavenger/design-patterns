# Memento Design Pattern

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
12. [Example: State Management System](#example-state-management-system)
13. [Conclusion](#conclusion)

## Introduction

The Memento design pattern is a behavioral design pattern that allows capturing and externalizing an object's internal state without violating encapsulation, so that the object can be restored to this state later.

## Definition

The Memento pattern provides the ability to restore an object to its previous state (undo via rollback).

## Components

The Memento pattern consists of these key components:

1. **Originator**: The object whose state needs to be saved and restored.
2. **Memento**: The object that stores the internal state of the Originator.
3. **Caretaker**: The object responsible for keeping track of multiple Memento objects.

## Purpose

The main purposes of the Memento pattern are:
1. To provide a way to implement undoable actions.
2. To store snapshots of an object's state without violating encapsulation.
3. To implement rollback and recovery mechanisms.
4. To allow an object to capture its internal state externally.

## Structure

Here's a basic structure of the Memento pattern:

```
Client --> Caretaker
             |
             v
          Originator <----> Memento
```

## Implementation

Here's a basic implementation structure:

```java
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        
        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());
        
        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());
        
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());		
        
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

## Use Cases

The Memento pattern is useful in the following scenarios:

1. Implementing undo/redo functionality in applications.
2. Creating snapshots of an object's state for backup and recovery.
3. In transaction processing systems where rollback might be necessary.
4. In games for saving and restoring game states.
5. In version control systems for managing different versions of documents.

## Advantages

1. **Encapsulation preservation**: It doesn't expose the details of the internal state of objects.
2. **Simplifies Originator**: The Originator doesn't need to keep track of its previous states.
3. **Easy state recovery**: Provides an easy way to implement recovery of object states.
4. **Provides a recovery mechanism**: Without violating encapsulation, it provides a way to recover object states.

## Disadvantages

1. **Memory usage**: Storing many states can consume a lot of memory.
2. **Additional complexity**: It can add complexity to an application.
3. **Potential performance impact**: Creating and restoring mementos can be time-consuming for objects with complex states.
4. **Frequency of creating Mementos**: If Mementos are created too often, it can impact the system performance.

## Best Practices

1. **Limit state storage**: Be mindful of how many states you're storing to avoid excessive memory usage.
2. **Consider using serialization**: For complex objects, consider using serialization to create Mementos.
3. **Ensure encapsulation**: Make sure the Memento doesn't expose more information than necessary.
4. **Use with Command pattern**: Often used in conjunction with the Command pattern for implementing undo functionality.
5. **Consider performance**: Be aware of the performance implications of creating and restoring Mementos, especially for large objects.
6. **Immutable Mementos**: Consider making Mementos immutable to prevent accidental changes to saved states.

## Related Patterns

1. **Command**: Memento can be used to implement undoable operations in the Command pattern.
2. **Iterator**: Mementos can be used to capture the state of an iteration.
3. **Prototype**: Prototype can be used to implement Mementos when the state to be saved is substantial.
4. **State**: State objects in the State pattern can create Mementos of themselves.

## Example: State Management System

Let's examine a real-world example of the Memento pattern using a state management system:

```java
// Memento.java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}

// Originator.java
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public Memento saveStateToMemento() {
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}

// CareTaker.java
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();
    
    public void add(Memento state) {
        mementoList.add(state);
    }
    
    public Memento get(int index) {
        return mementoList.get(index);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());
        
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

In this example:

1. `Memento` is the object that stores the state of the Originator.
2. `Originator` is the object whose state needs to be saved and restored.
3. `CareTaker` is responsible for keeping track of multiple Memento objects.
4. `Main` acts as the client, demonstrating how to use the Memento pattern to save and restore states.

This structure allows the application to save and restore the state of the Originator object without violating encapsulation. The Originator can create a Memento containing a snapshot of its internal state, and later use that Memento to restore its state.

## Conclusion

The Memento design pattern is a powerful tool for implementing undo mechanisms, creating snapshots of object states, and managing object state history. It's particularly useful in scenarios where you need to provide undo functionality or maintain a history of object states. While it can introduce some complexity and potential memory overhead, when used appropriately, it can significantly improve the flexibility and robustness of your application. Understanding when and how to apply the Memento pattern is a valuable skill for developers working on systems that require state management, undo functionality, or version control features.