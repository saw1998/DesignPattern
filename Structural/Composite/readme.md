
1. What is the Composite Pattern?
Definition:
The Composite Pattern is a structural design pattern that lets you treat individual objects and compositions of objects uniformly.

Key idea:

You have a tree-like structure (Part → Whole relationship).

You want clients to treat leaf objects (individual items) and composite objects (groups of items) the same way.

2. Real-world analogy
Think of a file system:

File = Leaf node (cannot contain other objects)

Folder = Composite node (can contain files and/or folders)

Both File and Folder share the same operations: open, display, delete, etc.

3. UML Structure

           Component
           + operation()
               / \
              /   \
          Leaf   Composite
                 + add(Component)
                 + remove(Component)
                 + getChild(int)