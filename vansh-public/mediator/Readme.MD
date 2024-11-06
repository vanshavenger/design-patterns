# Mediator Design Pattern

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
12. [Example: Chat Application](#example-chat-application)
13. [Conclusion](#conclusion)

## Introduction

The Mediator design pattern is a behavioral design pattern that reduces coupling between components of a program by making them communicate indirectly, through a special mediator object. The Mediator pattern promotes loose coupling by keeping objects from referring to each other explicitly, allowing you to vary their interaction independently.

## Definition

The Mediator pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly, allowing you to vary their interaction independently.

## Components

The Mediator pattern consists of these key components:

1. **Mediator**: Defines an interface for communicating with Colleague objects.
2. **ConcreteMediator**: Implements the Mediator interface and coordinates communication between Colleague objects.
3. **Colleague**: Defines an interface for objects communicating with each other through the mediator.
4. **ConcreteColleague**: Implements the Colleague interface and communicates with other Colleagues through its mediator.

## Purpose

The main purposes of the Mediator pattern are:
1. To reduce coupling between components of a program.
2. To centralize complex communications and control between related objects.
3. To promote reusability of objects.
4. To simplify maintenance of the system.

## Structure

Here's a basic structure of the Mediator pattern:

```
    Mediator <---- ConcreteMediator
    ^    ^                 |
    |    |                 |
    |    |                 v
Colleague1   Colleague2 <----
```

## Implementation

Here's a basic implementation structure:

```java
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator m) {
        mediator = m;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator m) { super(m); }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println("Colleague1 received: " + message);
    }
}

class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator m) { super(m); }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println("Colleague2 received: " + message);
    }
}

class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague) {
        this.colleague1 = colleague;
    }

    public void setColleague2(ConcreteColleague2 colleague) {
        this.colleague2 = colleague;
    }

    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receive(message);
        } else {
            colleague1.receive(message);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("How are you?");
        colleague2.send("Fine, thanks");
    }
}
```

## Use Cases

The Mediator pattern is useful in the following scenarios:

1. When a set of objects communicate in well-defined but complex ways.
2. When reusing an object is difficult because it refers to and communicates with many other objects.
3. When a behavior that's distributed between several classes should be customizable without a lot of subclassing.
4. In GUI component frameworks, where components need to interact with each other.
5. In air traffic control systems, where various elements need to communicate without direct references to each other.
6. In chat applications, where users can send messages to each other without direct connections.

## Advantages

1. **Reduces coupling**: It limits subclassing and prevents a system from being overly complex.
2. **Centralizes control**: The mediator centralizes control that, in a non-mediator system, would be distributed among objects.
3. **Simplifies object protocols**: A mediator replaces many-to-many interactions with one-to-many interactions.
4. **Increases reusability**: By removing direct references between objects, it's easier to reuse objects in different parts of the system.

## Disadvantages

1. **Complexity**: The mediator itself can become overly complex and hard to maintain.
2. **Centralization**: The mediator can become a single point of failure or a performance bottleneck.
3. **God Object**: Without careful design, the mediator can evolve into a God Object, an object that knows about and does too much.

## Best Practices

1. **Keep the Mediator Focused**: Ensure that the mediator only handles communication logic, not business logic.
2. **Consider Using Events**: In some cases, using an event-driven approach can simplify the mediator's implementation.
3. **Don't Overuse**: Use the Mediator pattern only when the coupling between objects is a problem.
4. **Balance Responsibilities**: Be careful not to create a "God" mediator. If a mediator becomes too complex, consider splitting it into multiple mediators.
5. **Use with Other Patterns**: The Mediator pattern can be effectively combined with other patterns like Observer or Command.

## Related Patterns

1. **Facade**: While Mediator centralizes communication between components, Facade provides a simplified interface to a subsystem.
2. **Observer**: Mediator can use Observer to dynamically register and unregister colleagues.
3. **Command**: Mediator can use Command to encapsulate requests as objects.
4. **Singleton**: The Mediator is often implemented as a Singleton.

## Example: Chat Application

Let's examine a real-world example of the Mediator pattern using a chat application:

```java
// ChatMediator.java (Mediator)
public interface ChatMediator {
    public void sendMessage(String message, User user);
    public void addUser(User user);
}

// User.java (Colleague)
public abstract class User {
    protected ChatMediator mediator;
    protected String name;
 
    public User(ChatMediator med, String name){
        this.mediator=med;
        this.name=name;
    }
     
    public abstract void send(String msg);
    public abstract void receive(String msg);
}

// UserImpl.java (ConcreteColleague)
public class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }
  
    @Override
    public void send(String msg){
        System.out.println(this.name+": Sending Message="+msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name+": Received Message:"+msg);
    }
}

// ChatMediatorImpl.java (ConcreteMediator)
import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;
  
    public ChatMediatorImpl(){
        this.users=new ArrayList<>();
    }
  
    @Override
    public void addUser(User user){
        this.users.add(user);
    }
  
    @Override
    public void sendMessage(String message, User user) {
        for(User u : this.users){
            //message should not be received by the user sending it
            if(u != user){
                u.receive(message);
            }
        }
    }
}

// Main.java (Client)
public class Main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Pankaj");
        User user2 = new UserImpl(mediator, "Lisa");
        User user3 = new UserImpl(mediator, "Saurabh");
        User user4 = new UserImpl(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        user1.send("Hi All");
        user2.send("Hi All");
    }
}
```

In this example:

1. `ChatMediator` is the Mediator interface.
2. `User` is the Colleague abstract class.
3. `UserImpl` is the ConcreteColleague class.
4. `ChatMediatorImpl` is the ConcreteMediator class.
5. `Main` acts as the Client, creating and using the mediator and colleagues.

This structure allows users to communicate with each other through the mediator, without having direct references to each other. The mediator centralizes the communication logic, making it easier to maintain and extend the chat functionality.

## Conclusion

The Mediator design pattern is a powerful tool for reducing coupling between components in a system. It's particularly useful in scenarios where you have complex interactions between multiple objects and want to centralize the communication logic. While it can introduce some complexity in the mediator itself, when used appropriately, it can significantly improve the maintainability and flexibility of your code. Understanding when and how to apply the Mediator pattern is a valuable skill for any developer working on systems with complex object interactions.