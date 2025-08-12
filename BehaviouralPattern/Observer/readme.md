1. What is the Observer Pattern?
Definition:
The Observer Pattern defines a one-to-many dependency between objects so that when one object (Subject) changes state, all its dependents (Observers) are notified automatically.

Real-world analogy
YouTube Channel = Subject

Subscribers = Observers

When the YouTube channel uploads a new video (state change), all subscribers get a notification.

Key Participants
Subject — maintains a list of observers and notifies them of changes.

Observer — defines an update method that is called when the subject changes.

Concrete Subject — implements the Subject interface, stores state.

Concrete Observer — implements the Observer interface and reacts to updates.

