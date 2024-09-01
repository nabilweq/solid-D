## Dependency Inversion Principle (D in SOLID)

In the code original doTransaction method, the Payment class directly created and used Razorpay and JusPay. This made the Payment class depend on these specific payment gateways, making it hard to change or add new ones.

To fix this, I introduced an interface called PaymentGateway, which both Razorpay and JusPay now implement. Instead of directly interact with Razorpay or JusPay, the Payment class now interact with the PaymentGateway interface. This way, the Payment class doesn’t need to know the details of how each gateway works, making the code easier to maintain and extend.