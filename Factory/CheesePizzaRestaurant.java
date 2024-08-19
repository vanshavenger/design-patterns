package Factory;

public class CheesePizzaRestaurant extends Restaurant {
    @Override
    public Pizza createPizza() {
        System.out.println("Creating Cheese Pizza");
        return new CheesePizza();
    }

    @Override
    public Burger createBurger() {
        System.out.println("Creating Cheese Burger");
        return new CheeseBurger();
    }
}
