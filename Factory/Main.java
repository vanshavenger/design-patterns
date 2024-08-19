package Factory;

public class Main {
    public static void main(String[] args) {
        Restaurant cheesePizza = new CheesePizzaRestaurant();
        cheesePizza.orderPizza();

        Restaurant pepPizza = new PepPizzaRestaurant();
        pepPizza.orderPizza();

        cheesePizza.OrderBurger();
        pepPizza.OrderBurger();
    }
}
