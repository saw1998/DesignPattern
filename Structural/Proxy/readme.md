1. What is the Proxy Pattern?
Definition

The Proxy Pattern provides a placeholder or surrogate object that controls access to another object.

Key idea: Instead of interacting directly with a real object (which might be resource-heavy, sensitive, or remote), we use a proxy object that manages how and when the real object is accessed.

2. Types of Proxies
Virtual Proxy → Lazy loading of heavy objects (e.g., load images only when needed).

Protection Proxy → Control access based on permissions.

Remote Proxy → Access an object in another JVM / server.

Cache Proxy → Store results to avoid re-computation.

3. UML Diagram
typescript
Copy
Edit
   Client
     |
   Subject (interface)
   /         \
Proxy      RealSubject
Subject: Common interface for real object and proxy.

RealSubject: The actual object doing the work.

Proxy: Holds a reference to RealSubject and controls access.