public class CheeseBurstDecorator extends PizzaDecorator {
    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public String bake() {
        return "Cheese Burst " + pizza.bake();
    }
    
}
