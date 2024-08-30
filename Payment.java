
public class Payment {

    public void doTransaction(){
        String cardNo = "1234";
        String expiry = "12/12";
        int cvv = 123;
        int otp = 1234;

// Common method
//        double x = Math.random() * 10;
//        if(x <= 2){
//            Razorpay razorpay = new Razorpay();
//            razorpay.doPayment(cardNo, expiry, cvv, otp, 1000);
//        } else {
//            // juspay
//            JusPay jusPay = new JusPay();
//            jusPay.makePayment(1000, expiry, cardNo, cvv, otp);
//        }
// Here we use (Dependency Inversion)

        double x = Math.random() * 10;
        PaymentGateway pg = null;
        if(x <= 2){
            pg = new Razorpay();
        } else{
            pg = new JusPay();
        }
        
        pg.payment(cardNo, expiry, cvv, otp, 10000);

        if (pg instanceof Identifiable) {
            System.out.println("Using " + ((Identifiable) pg).getName() + " for this transaction.");
        } else {
            System.out.println("Using an unidentified payment gateway for this transaction.");
        }
        
    }
}

// PhonePe -> 20 Razorpay, 30 PhonePe, 50 JusPay
// That defines the behaviour but not the implmentation
// What but not how to do it
