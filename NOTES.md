# Notes

### Java

<details>
  <summary>OOP</summary>
  
  - Abstraction: develop classes in terms of their own functionality, instead of their implementation details.
  - Encapsulation: objects hide their internal characteristics and behavior.
  - Polymorphism: present the same interface for differing underlying data types.
    - Compile-time polymorphism (Static binding) – Method overloading
    - Runtime polymorphism (Dynamic binding) – Method overriding
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
  
  Boolean, byte, char, int, float, double, long, short
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
  - Static class
  - Static block: code executed when loading the class in memory
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

