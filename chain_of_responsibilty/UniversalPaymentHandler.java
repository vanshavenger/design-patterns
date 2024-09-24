package chain_of_responsibilty;

public class UniversalPaymentHandler extends PaymentHandler {

    @Override
    public void handleRequest(double amount) {
        System.out.println("Processing payment by universal payment gateway");
    }
    
}
