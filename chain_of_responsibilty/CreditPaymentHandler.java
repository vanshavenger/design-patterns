package chain_of_responsibilty;

public class CreditPaymentHandler extends PaymentHandler {
    public void handleRequest(double amount) {
        if (amount <= 1000) {
            System.out.println("Processing payment by credit");
        } else {
            next.handleRequest(amount);
        }
    }
    
}
