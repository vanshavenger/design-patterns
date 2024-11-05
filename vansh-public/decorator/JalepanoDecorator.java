public class JalepanoDecorator extends PizzaDecorator {
    public JalepanoDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public String bake() {
        return "Jalepano " + pizza.bake();
    }
    
}
