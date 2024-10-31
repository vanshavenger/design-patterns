
# Factory Pattern Documentation

## Introduction
The Factory Pattern is a **creational design pattern** that provides an interface for creating objects in a super-class, but allows subclasses to alter the type of objects that will be created. The purpose of this pattern is to abstract the process of instantiating classes, enabling us to manage the creation process dynamically.

---

## Problem Statement
In traditional programming, the instantiation of a class is done directly using the `new` keyword, which is effective but limits flexibility. As software grows in complexity, this approach becomes restrictive and difficult to maintain. If we have a client class that directly instantiates specific classes, we introduce a high level of coupling between classes, reducing flexibility.

For example, consider an application that supports multiple operating systems. Directly creating instances of specific OS classes in client code (like `Windows` or `Linux`) can be inefficient and challenging to extend.

---

## Solution: Factory Pattern
The Factory Pattern solves this problem by defining a factory class responsible for creating instances of specific classes. This enables the client code to interact with the factory rather than the specific classes, making the code more flexible and easier to maintain.

### Benefits
- **Encapsulation of Object Creation**: Centralizes the creation logic, keeping the code organized.
- **Decoupling**: Allows the client code to rely on a common interface instead of specific implementations.
- **Enhanced Maintainability**: Adding new types or changing the instantiation logic requires changes only in the factory.

---

## Implementation of Factory Pattern

### 1. Abstract Base Class (`OperatingSystem`)
The abstract class `OperatingSystem` defines a blueprint for an operating system, specifying the methods `changeDir` and `removeDir`.

```java
public abstract class OperatingSystem {
    private String version;
    private String architecture;

    public OperatingSystem(String version, String architecture) {
        this.version = version;
        this.architecture = architecture;
    }

    public String getVersion() {
        return version;
    }

    public String getArchitecture() {
        return architecture;
    }

    public abstract void changeDir(String dir);
    public abstract void removeDir(String file);
}
```

### 2. Concrete Classes (`Linux` and `Windows`)
Each specific OS class (`Linux` and `Windows`) extends `OperatingSystem` and implements the methods.

```java
public class Linux extends OperatingSystem {
    public Linux(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        System.out.println("using LINUX: Changing directory to " + dir);
    }

    @Override
    public void removeDir(String file) {
        System.out.println("using LINUX: Removing directory " + file);
    }
}

public class Window extends OperatingSystem {
    public Window(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        System.out.println("using WINDOWS: Changing directory to " + dir);
    }

    @Override
    public void removeDir(String file) {
        System.out.println("using WINDOWS: Removing directory " + file);
    }
}
```

### 3. Factory Class (`OperatingSystemFactory`)
The factory class creates instances of `OperatingSystem` subclasses based on a given parameter.

```java
public class OperatingSystemFactory {
    public static OperatingSystem getInstance(String type, String version, String architecture) {
        if ("WINDOWS".equalsIgnoreCase(type)) {
            return new Window(version, architecture);
        } else if ("LINUX".equalsIgnoreCase(type)) {
            return new Linux(version, architecture);
        }
        throw new IllegalArgumentException("Unknown operating system type.");
    }
}
```

### 4. Client Code (`Main` class)
The client code demonstrates how the `OperatingSystemFactory` creates OS instances without the client knowing which class is instantiated.

```java
public class Main {
    public static void main(String[] args) {
        OperatingSystem windows = OperatingSystemFactory.getInstance("WINDOWS", "10", "64-bit");
        OperatingSystem linux = OperatingSystemFactory.getInstance("LINUX", "Ubuntu", "64-bit");

        windows.changeDir("C:\Users\user\Desktop");
        windows.removeDir("C:\Users\user\Desktop\file.txt");

        linux.changeDir("/home/user/Desktop");
        linux.removeDir("/home/user/Desktop/file.txt");
    }
}
```

---

## Pros and Cons

### Pros
- **Encapsulates Object Creation**: Makes code more modular by centralizing instantiation.
- **Decouples Classes**: Changes in object creation logic don’t affect client code.
- **Scalability**: Allows addition of new classes with minimal changes.

### Cons
- **Increased Complexity**: Overusing the pattern can add unnecessary complexity.
- **Performance Impact**: Factory methods may add a slight overhead in certain scenarios.

---

## Real-World Use Cases
- **Cross-Platform Development**: Applications that need to support multiple platforms (e.g., `Windows`, `Linux`, `macOS`).
- **Database Connections**: Creating database connections based on the type of database required (e.g., `MySQL`, `PostgreSQL`).
- **Payment Systems**: Systems that need to support multiple payment methods (e.g., `CreditCard`, `PayPal`).

---

## Conclusion
The Factory Pattern is a useful design pattern for applications needing flexibility and scalability in object creation. By decoupling object creation from the client, it simplifies maintenance and testing, especially for complex applications with multiple object types.

