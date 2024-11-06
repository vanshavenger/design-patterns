
import java.awt.Color;
import java.awt.Graphics;

public class Oval implements Shape {

    private boolean isFilled;

    public Oval(boolean isFilled) {
        this.isFilled = isFilled;
        if (isFilled) {
            System.out.println("Creating a filled oval");
        }
        else {
            System.out.println("Creating an oval");
        }
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
        }
    }

    @Override
    public void draw(Graphics oval, int x, int y, int width, int height, Color color) {
        oval.setColor(color);
        oval.fillOval(x, y, width, height);
        if (!isFilled) {
            oval.fillOval(x, y, width, height);
        }
    }

}
