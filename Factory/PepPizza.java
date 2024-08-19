package Factory;

public class PepPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza");
    }

}
