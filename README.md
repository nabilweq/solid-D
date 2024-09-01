## Dependency Inversion Principle (D in SOLID)

High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces). Abstractions should not depend on details. Details should depend on abstractions."

In simpler terms, this means:

Your main logic (high-level code) should not be tied to specific details or implementations (low-level code).
Instead, both your high-level logic and low-level implementations should rely on a common interface or abstract class.

In the code original doTransaction method, the Payment class directly created and used Razorpay and JusPay. This made the Payment class depend on these specific payment gateways, making it hard to change or add new ones.

To fix this, I introduced an interface called PaymentGateway, which both Razorpay and JusPay now implement. Instead of directly interact with Razorpay or JusPay, the Payment class now interact with the PaymentGateway interface. This way, the Payment class doesn’t need to know the details of how each gateway works, making the code easier to maintain and extend.