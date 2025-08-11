
public class Singleton {
    private static volatile Singleton instance; //volatile makes sure ther is no partial cration of object (which could be referenced by another thread)

    private Singleton() {} // private constructor

    public static Singleton getInstance() {
        if (instance == null) { // first check (fast)
            synchronized (Singleton.class) {  //(slow synchronized block)
                if (instance == null) { // double-check 
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


/*
Why volatile is Needed
Object creation in Java is not always a simple "one step" process — it can be reordered by the compiler or CPU for optimization.

Creating a new object:

java
Copy
Edit
instance = new Singleton();
can internally be:

Allocate memory

Initialize object

Assign reference to instance

Without volatile, step 3 could happen before step 2 (due to instruction reordering).
That means another thread could see a non-null instance but still use a half-initialized object, causing bugs.

With volatile:

Prevents instruction reordering.

Ensures that writes to instance are visible to all threads immediately.


✅ In short:

Double-checked locking = avoids unnecessary synchronization after initialization.

volatile = prevents partially constructed objects from being seen by other threads.
*/

