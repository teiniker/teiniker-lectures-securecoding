# Value Object Pattern

The Value Object Pattern is a design pattern used in the domain of 
domain-driven design. 

Here are the key aspects of this pattern:
* **Immutability**: Value objects are immutable, meaning once they 
    are created, their state cannot be changed. This makes them 
    inherently safe for use in a concurrent environment since they 
    can't be modified once they've been instantiated.

* **Identity-less**: Unlike entities, value objects do not have a unique 
    identity. Two value objects are considered equal if all their fields 
    are equal. Their identity is solely based on their attributes, not 
    on a unique identifier.

* **Self-validation**: Value objects should validate their own state 
    during creation. This ensures they are always in a valid state once 
    they are instantiated.

* **Simplicity and Focus**: They typically have a small number of attributes 
    and are focused on modeling a specific aspect of the domain. 
    For example, an `Address` value object might include fields for street, 
    city, and postal code, and nothing more.

* **Lifecycle**: They are often created, used for a specific calculation or 
    operation, and then discarded. They don't usually have a long lifecycle 
    within the application.

The Value Object pattern can be effectively used in the context of software 
security, particularly for **input validation**.

By using value objects for input validation, we ensure **consistency** throughout 
the application. Instead of scattering validation logic across the application, 
it is centralized within the value object, making it easier to maintain and update 
the validation rules as needed.


## References
* [Martin Fowler: ValueObject](https://martinfowler.com/bliki/ValueObject.html)
* Eric Evans. **Domain-Driven Design: Tackling Complexity in the Heart of Software**. Pearson International, 2003.

*Egon Teiniker, 2016-2024, GPL v3.0*