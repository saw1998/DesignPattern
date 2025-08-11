1️⃣ What is the Bridge Pattern?
Category: Structural Pattern

Purpose:

Decouple an abstraction from its implementation so that both can vary independently.

It’s like saying:

"I don’t want my high-level interface and my low-level implementation glued together — let’s keep them separate and ‘bridge’ them."

2️⃣ Why use it?
When you have multiple dimensions of variation (e.g., shape type and color type).

Prevents class explosion (e.g., RedCircle, BlueCircle, RedSquare, BlueSquare...).

Makes the system easier to extend — you can add new abstractions or implementations without touching the other.




3️⃣ UML Structure

       Abstraction
           |
           v
     RefinedAbstraction
           |
           +------------------+
                              |
                           Implementor <---- ConcreteImplementorA
                              ^             ConcreteImplementorB
Key roles:

Abstraction — defines high-level interface; holds a reference to Implementor.

RefinedAbstraction — extends abstraction with more features.

Implementor — interface for low-level operations.

ConcreteImplementor — actual implementation details.


____________________________________________________________________________


1. What is the Bridge Pattern?
Definition
The Bridge Pattern is a structural pattern that decouples an abstraction from its implementation so the two can vary independently.

When to use

When you have two orthogonal dimensions that may change independently.

When you don’t want to hardcode implementation details into the abstraction.

When inheritance would cause a class explosion.

