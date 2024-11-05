# Proxy Design Pattern

## Table of Contents
1. [Introduction](#introduction)
2. [Purpose](#purpose)
3. [Structure](#structure)
4. [Types of Proxy](#types-of-proxy)
5. [Implementation](#implementation)
6. [Use Cases](#use-cases)
7. [Advantages](#advantages)
8. [Disadvantages](#disadvantages)
9. [Best Practices](#best-practices)
10. [Related Patterns](#related-patterns)
11. [Example: ATM System](#example-atm-system)
12. [Conclusion](#conclusion)

## Introduction

The Proxy design pattern is a structural pattern that provides a surrogate or placeholder for another object to control access to it. This pattern is used to create a representative object that controls access to another object, which may be remote, expensive to create, or in need of securing.

## Purpose

The main purposes of the Proxy pattern are:
1. To control access to an object.
2. To provide a placeholder for an object to control its creation and lifetime.
3. To implement lazy initialization and loading.
4. To add a wrapper and delegation to protect the real component from undue complexity.

## Structure

The Proxy pattern consists of these key components:

1. **Subject**: An interface declaring common operations for both RealSubject and Proxy.
2. **RealSubject**: The real object that the proxy represents.
3. **Proxy**: Maintains a reference to the RealSubject and controls access to it.

## Types of Proxy

1. **Virtual Proxy**: Creates expensive objects on demand.
2. **Remote Proxy**: Provides a local representative for an object in a different address space.
3. **Protection Proxy**: Controls access to the original object.
4. **Smart Reference**: Provides additional actions when an object is accessed.

## Implementation

Here's a basic implementation structure:

```java
interface Subject {
    void request();
}

class RealSubject implements Subject {
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("Proxy: Pre-request processing.");
    }

    private void postRequest() {
        System.out.println("Proxy: Post-request processing.");
    }
}

public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}
```

## Use Cases

The Proxy pattern is useful in the following scenarios:

1. Lazy initialization (virtual proxy)
2. Access control (protection proxy)
3. Local execution of a remote service (remote proxy)
4. Logging requests (logging proxy)
5. Caching object results (caching proxy)
6. Reference counting (smart reference proxy)

## Advantages

1. **Security**: The proxy can validate access before forwarding the request to the real object.
2. **Performance**: It can improve performance through lazy loading and caching.
3. **Reduced Complexity**: It can add functionality without changing the real subject.
4. **Remote Access**: It can provide a local representation for a remote object.

## Disadvantages

1. **Increased Complexity**: Adding another layer can complicate the design.
2. **Performance Overhead**: In some cases, the proxy can introduce a slight delay.
3. **Potential for Abuse**: Overuse of the proxy pattern can lead to a system that's hard to understand and maintain.

## Best Practices

1. **Keep it Simple**: Use the proxy only when you need to add a level of indirect access.
2. **Implement the Subject Interface**: Ensure that your proxy implements the same interface as the real subject.
3. **Consider Performance**: Be aware of potential performance impacts, especially with remote proxies.
4. **Use for Cross-Cutting Concerns**: Proxies are great for adding logging, caching, or access control without modifying the real subject.
5. **Lazy Initialization**: Use virtual proxies for expensive object creation.

## Related Patterns

1. **Adapter**: While proxy provides the same interface, adapter provides a different interface to its subject.
2. **Decorator**: Decorator adds responsibilities to an object, while Proxy controls access to an object.
3. **Facade**: Facade provides a simplified interface to a set of objects, while Proxy controls access to a single object.

## Example: ATM System

Let's examine a real-world example of the Proxy pattern using a simplified ATM system:

```java
// Account.java
public interface Account {
    public void withdraw();
    public double getBalance();
}

// BankAccount.java
public class BankAccount implements Account {
    @Override
    public void withdraw() {
        System.out.println("Withdrawn from BankAccount");
    }

    @Override
    public double getBalance() {
        return 0;
    }
}

// ATM.java (Proxy)
public class ATM implements Account {
    private BankAccount bankAccount;

    @Override
    public void withdraw() {
        if (bankAccount == null) {
            bankAccount = new BankAccount();
        }
        // Additional security checks or logging could be added here
        System.out.println("ATM: Processing withdrawal request");
        bankAccount.withdraw();
    }

    @Override
    public double getBalance() {
        if (bankAccount == null) {
            bankAccount = new BankAccount();
        }
        // Additional security checks or logging could be added here
        return bankAccount.getBalance();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Account account = new ATM();
        account.withdraw();
    }
}
```

In this example:

1. `Account` is the Subject interface declaring common operations.
2. `BankAccount` is the RealSubject that implements the Account interface.
3. `ATM` is the Proxy that also implements the Account interface and contains a reference to a BankAccount.
4. The `Main` class demonstrates how the client interacts with the BankAccount through the ATM proxy.

The Proxy pattern in this context allows the ATM to control access to the BankAccount, potentially adding security checks, logging, or other functionality without changing the BankAccount class itself.

## Conclusion

The Proxy design pattern is a powerful tool for controlling access to objects, whether for security, performance, or other reasons. It's particularly useful in scenarios where you need to add a layer of indirection to object interactions without changing the objects themselves. While it can introduce some complexity, when used appropriately, it can significantly improve the security, efficiency, and flexibility of your system. Understanding when and how to apply the Proxy pattern is a valuable skill for any developer working on complex systems that require controlled access to resources.