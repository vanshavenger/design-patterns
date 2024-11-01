public class TwoWheelerVehicle extends Vehicle {

    private final String isElectric;

    public TwoWheelerVehicle(String engine, String color, String model, String isElectric) {
        super(engine, color, model);
        this.isElectric = isElectric;
    }

    @Override
    protected TwoWheelerVehicle clone() throws CloneNotSupportedException {
        return (TwoWheelerVehicle) super.clone();
    }
    
}
