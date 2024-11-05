public class BankAccount implements Account {
    
    @Override
    public void withdraw() {
        System.out.println("Withdrawn from BankAccount");
    }

    @Override
    public double getBalance() {
        return 0;
    }
    
    
}
