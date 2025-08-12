1. What is the Flyweight Pattern?
Category: Structural Design Pattern

Intent: Reduce memory usage by sharing objects instead of creating new ones for every use.

Key Idea: Store intrinsic state (shared, constant data) inside flyweight objects, and pass extrinsic state (context-specific data) when needed.

💡 In simple terms:
If you have thousands of objects that look similar, don’t store duplicates — store one shared object and reuse it.

2. Real-world analogy
Characters in a text editor
Every letter ‘a’ looks the same, so instead of creating a new object for each, we store one ‘a’ object and reuse it. The position (x, y) where it is drawn is extrinsic.

Chess game
A white pawn looks the same in all positions — store only one pawn object, and change its position dynamically.

3. UML Overview
          Flyweight
             ↑
ConcreteFlyweight   UnsharedConcreteFlyweight
             ↑
         FlyweightFactory
             ↑
            Client

_________________________________________________________

6. Key Interview Notes
Intrinsic State: Shared, constant across objects (e.g., character shape, tree type).

Extrinsic State: Passed at runtime, varies for each object use (e.g., font size, position).

Advantages:

Huge memory savings when dealing with many similar objects.

Improves performance in object-heavy systems.

Disadvantages:

Adds complexity — need to separate intrinsic and extrinsic state.

Might make code harder to understand if overused.

Common Use Cases:

Game objects (bullets, enemies, tiles).

Text rendering.

GUI icons.

Caching and object pooling.