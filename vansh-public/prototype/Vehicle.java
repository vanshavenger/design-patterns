public abstract class Vehicle implements Cloneable {
    private String engine;
    private String color;
    private String model;

    public Vehicle(String engine, String color, String model) {
        this.engine = engine;
        this.color = color;
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    protected Vehicle clone() throws CloneNotSupportedException {
        return (Vehicle) super.clone();
    }
}
