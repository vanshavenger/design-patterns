package Factory;

public abstract class Restaurant {
    public void orderPizza() {
        System.out.println("Ordering Pizza");
        Pizza pizza = createPizza();
        pizza.prepare();
    }

    public void OrderBurger() {
        System.out.println("Ordering Burger");
        Burger burger = createBurger();
        burger.prepare();
    }

    public abstract Pizza createPizza();

    public abstract Burger createBurger();
}
