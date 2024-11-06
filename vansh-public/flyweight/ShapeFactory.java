import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);
        if (shapeImpl == null) {
            shapeImpl = switch (type) {
                case OVAL_FILL -> new Oval(true);
                case OVAL_NOFILL -> new Oval(false);
                case LINE -> new Line();
            };
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }
    


    public static enum ShapeType {
        OVAL_FILL, OVAL_NOFILL, LINE;
    }
    
}
