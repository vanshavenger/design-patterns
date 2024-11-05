public class Main {
    public static void main(String[] args) {
        Pizza pizza = new JalepanoDecorator(new BasePizza());
        System.out.println(pizza.bake());

        pizza = new JalepanoDecorator(new JalepanoDecorator(new BasePizza()));
        System.out.println(pizza.bake());

        pizza = new JalepanoDecorator(new JalepanoDecorator(new CheeseBurstDecorator(new BasePizza())));
        System.out.println(pizza.bake());
    }
}