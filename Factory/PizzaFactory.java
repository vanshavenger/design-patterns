package Factory;

public class PizzaFactory {
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("pepperoni")) {
            return new PepPizza();
        } else {
            return null;
        }
    }
}
