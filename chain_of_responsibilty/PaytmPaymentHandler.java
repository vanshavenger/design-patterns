package chain_of_responsibilty;

public class PaytmPaymentHandler extends PaymentHandler {
    public void handleRequest(double amount) {
        if (amount <= 2000) {
            System.out.println("Processing payment by Paytm");
        } else {
            System.out.println("Payment failed");
        }
    }
}
