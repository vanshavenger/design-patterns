public class FourWheelerVehicle extends Vehicle {
    
    private final boolean automatic;

    private final boolean isDiesel;

    public FourWheelerVehicle(String engine, String color, String model, boolean automatic, boolean isDiesel) {
        super(engine, color, model);
        this.automatic = automatic;
        this.isDiesel = isDiesel;
    }

    
    @Override
    protected FourWheelerVehicle clone() throws CloneNotSupportedException {
        return (FourWheelerVehicle) super.clone();
    }


    
}
