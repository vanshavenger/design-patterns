
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ShapeFactory.getShape(ShapeFactory.ShapeType.OVAL_FILL).draw(g, 10, 10, 100, 50, Color.decode("#FF0000")); // Red
        ShapeFactory.getShape(ShapeFactory.ShapeType.OVAL_NOFILL).draw(g, 120, 10, 100, 50, Color.GREEN); // Green
        ShapeFactory.getShape(ShapeFactory.ShapeType.LINE).draw(g, 10, 70, 120, 70, Color.BLUE); // Blue
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Drawer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.setVisible(true);
    }
}