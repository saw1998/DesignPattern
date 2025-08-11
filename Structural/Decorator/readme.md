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

