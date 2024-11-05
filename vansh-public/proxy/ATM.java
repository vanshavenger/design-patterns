public class ATM implements Account {
    @Override
    public void withdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw();

    }

    @Override
    public double getBalance() {
        return 0;
    }
    
}