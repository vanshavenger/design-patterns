
package Factory;

public class PepPizzaRestaurant extends Restaurant {
    @Override
    public Pizza createPizza() {
        System.out.println("Creating Pep Pizza");
        return new PepPizza();
    }

    @Override
    public Burger createBurger() {
        System.out.println("Creating Pep Burger");
        return new PepBurger();
    }
}