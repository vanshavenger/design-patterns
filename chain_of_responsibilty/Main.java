package chain_of_responsibilty;

public class Main {

    public static void main(String[] args) {
        PaymentHandler bankPaymentHandler = new BankPaymentHandler();
        PaymentHandler creditPaymentHandler = new CreditPaymentHandler();
        PaymentHandler paytmPaymentHandler = new PaytmPaymentHandler();

        bankPaymentHandler.setNext(creditPaymentHandler);
        creditPaymentHandler.setNext(paytmPaymentHandler);

        bankPaymentHandler.handleRequest(100);
        bankPaymentHandler.handleRequest(600);
        bankPaymentHandler.handleRequest(2000);
        bankPaymentHandler.handleRequest(5000);
    }
    
}
