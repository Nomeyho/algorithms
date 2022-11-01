# Notes

### Java

<details>
  <summary>OOP</summary>
  
  - Abstraction: develop classes in terms of their own functionality, instead of their implementation details.
  - Encapsulation: objects hide their internal characteristics and behavior.
  - Polymorphism: present the same interface for differing underlying data types.
    - Compile-time polymorphism (static binding) – Method overloading
    - Runtime polymorphism (dynamic binding) – Method overriding
  - Inheritance: acquire fields and methods of the base class.
  - Predefined & user-defined types as objects.
  - Message-based.
  
  Java not 100% OO becquse of primitives types.
</details>

<details>
  <summary>Hello World</summary>
  
  ```
  public class HelloWorld {
    public static void main(String args[]) {  
      System.out.println("Hello World");  
    }
  }
  ```
</details>

<details>
  <summary>Primitive Types</summary>
  
  - Boolean, byte, char, int, float, double, long, short.
  - Java provides wrapper classes for each primitive type.
</details>

<details>
  <summary>Association vs Aggregation vs Composition</summary>
  
  - Association: link between two classes communicating with each other.
  - Aggregation and Composition are special cases of association.
  - Composition: the child cannot exist independent of the parent.
</details>

<details>
  <summary>JVM</summary>
  
  Process vthat can execute Java bytecode.
</details>

<details>
  <summary>JRE vs. JDK</summary>
  
  - JRE is a JVM implementation
  - JDK includes the JRE and development tools.
</details>

<details>
  <summary>Static</summary>
  
  - Static variable/method can be accessed without instantiation.
  - Static class.
  - Static block: code executed when loading the class in memory.
  
  Note: static fields and blocks are initialized one after another.
</details>

<details>
  <summary>Nested class</summary>
  
  - Not-static nested class has access to instance variable/methods of the outer class.
  - Not-static nested class cannot be instantiated without the outer class.
  - Static nested class have only access to static member of the outer class.
</details>

<details>
  <summary>Autoboxing</summary>
  
  Automatic conversion made by the Java compiler between the primitive types and their corresponding object wrapper classes.
</details>

<details>
  <summary>Method Overriding</summary>
  
  Child class redefines the same method as a parent class (cannot limit the access of the method).
</details>

<details>
  <summary>Method Overloading</summary>
  
  Methods in the same class that have the exact same name, but different parameters.
</details>

<details>
  <summary>Constructor</summary>
  
  - Default constructor
  - Support constructor overloading
  - Copy constructor
</details>

<details>
  <summary>Multiple inheritance</summary>
  
  Each class is able to extend only on one class but is able to implement more than one interfaces.
</details>

<details>
  <summary>Static method overloading & overriding</summary>
  
  - Static methods can be overloaded (static binding), but not by instance methods.
  - Static methods cannot be overriden (dynamic binding).
</details>

<details>
  <summary>Interface</summary>
  
  - Interface methods are implicitly abtracts.
  - Implement a number of interfaces.
  - Must implement all methods declared in the interface.
  - Variables declared in an interface are by default `public static final`.
  - Members of a Java interface are public by default.
  - An interface is public by default.
</details>

<details>
  <summary>Abstract class</summary>
  
  - Abstract class can have both abstract and non-abstract methods.
  - Extend only one abstract class.
  - **Abstract classes can implement interfaces without even providing the implementation of interface methods.**
</details>

<details>
  <summary>Pass by value vs. reference</summary>
  
  - Pass by value: a copy of the object is passed (Java primitive types).
  - Pass by reference: a pointer to the object is passed (Java objects).
</details>

<details>
  <summary>Volatile</summary>
  
  - Value not cached and always read from main memory.
  - TODO: https://www.javacodegeeks.com/2018/03/volatile-java-works-example-volatile-keyword-java.html
</details>

<details>
  <summary>Transient variable</summary>
  
  A transcient variable is not serialized.
</details>

<details>
  <summary>Local vs. instance variable</summary>
  
  - Local variable is declared inside a method or constructor.
  - Instance variable is declared inside a class.
  - Local variable must be initialized (compilation error).
</details>

<details>
  <summary>Access modifier</summary>
  
  - Public: accessible from everywhere.
  - Protected: accessible within the package and the subclasses in any package.
  - Package private (default): accessible within the package.
  - Private: accessible within the same class.
</details>

<details>
  <summary>Singleton</summary>
  
  - Single instance.
  - Global access.
</details>

<details>
  <summary>Double checked Singleton</summary>
  
  - Synchronized `getInstance` method results in poor performance.
  - Verify if the instance must be created before competing for the lock. 
    ```
    public class Singleton {
      private static volatile Singleton instance;
      public static Singleton getInstance() {
          if (instance == null) {
              synchronized (Singleton.class) {
                  if (instance == null) {
                      instance = new DclSingleton();
                  }
              }
          }
          return instance;
      }
    }
    ```
    The field needs to be volatile to prevent cache incoherence issues, becaue the *Java memory model* allows the publication of partially initialized objects.
  - Alternative:
    - Early initialisation.
    - Lazy initialization using a nested static class (the "holder").
    - Enum singleton.
</details>

<details>
  <summary>Threads</summary>
  
  - Extend `Thread` class and override `run` method.
  - Implement `Runnable` interface (preferred) and create a thread from it `new Thread(runnable)`.
  - Methods:
    - id, name, priority, state
    - `interrupt()`
    - `join()` waits for the thread to die.
    - `run()` contain the business logic.
    - `start()` creates a new thread and call the `run()` method.
    - `sleep()`
</details>
