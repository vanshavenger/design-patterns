package chain_of_responsibilty;

public class BankPaymentHandler extends PaymentHandler {

   @Override
   public void handleRequest(double amount) {
      if (amount <= 500) {
         System.out.println("Processing payment by bank");
      } else {
         next.handleRequest(amount);
      }
   }
    
}
