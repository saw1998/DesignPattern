1. Concept
The Command Pattern is a behavioral design pattern that turns a request into a standalone object containing all the information needed to execute it later.

It decouples the object that invokes the operation (Invoker) from the one that knows how to perform it (Receiver).

Commands can be queued, logged, undone, or redone easily.

2. UML Diagram
         Command (interface)
              ↑
    ConcreteCommand (LightOnCommand, LightOffCommand)
              ↑
           has-a
          Receiver (Light)

Invoker (RemoteControl) ----> calls execute() on Command