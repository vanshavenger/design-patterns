package Factory;

public class PepBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Simple Burger");
    }
}
