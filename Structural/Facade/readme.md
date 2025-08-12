1. What is the Facade Pattern?
Category: Structural Design Pattern

Intent: Provide a simplified interface to a complex subsystem.

Key Idea: Instead of dealing with many complicated classes and APIs directly, you create a Facade class that exposes a clean, easy-to-use interface.

Think of it like:

Instead of learning how to fly an airplane (hundreds of controls), you get a “Game Controller” that just has a few buttons to do the job.

2. Real-world analogy
TV Remote: You don’t manually connect wires, set channels, and adjust internal circuits — you just press ON and it works.

ATM Machine: You don’t have to deal with banking protocols; just insert your card and press buttons.

UML
Client → Facade → Subsystem classes (Complex logic)
