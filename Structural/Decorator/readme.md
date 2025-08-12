1. What is the Decorator Pattern?
Definition:
The Decorator Pattern is a structural design pattern that lets you dynamically add new behavior to objects at runtime without altering the original class.

Instead of creating multiple subclasses to add features, we "wrap" an object inside another object that adds functionality.

2. When to use
When you want to extend behavior without modifying existing code (Open-Closed Principle).

When subclass explosion becomes a problem (too many subclasses for each combination of features).

When you want runtime flexibility to add/remove responsibilities.

3. UML Structure

           Component
           + operation()
               / \
              /   \
          ConcreteComponent
          Decorator
           + operation()
                |
     ---------------------
     |                   |
 ConcreteDecoratorA   ConcreteDecoratorB
Component → Common interface for all objects.

ConcreteComponent → The main object to decorate.

Decorator → Abstract wrapper that implements the same interface and has a reference to a Component.

ConcreteDecorator → Adds extra functionality.

___________________________________________________________
6. Key Interview Points
Pros

Adheres to Open-Closed Principle.

Flexible and reusable.

Avoids subclass explosion.

Cons

Can lead to too many small objects.

Debugging can be tricky when many layers are wrapped.

Real-world use cases

Java I/O Streams (BufferedInputStream, DataInputStream, etc.).

UI frameworks (adding borders, shadows).

Logging frameworks.


//next step
If you want, I can also show you how Java’s BufferedReader, InputStream, etc. use the Decorator Pattern — it’s a classic real-world example that often gets asked in interviews.