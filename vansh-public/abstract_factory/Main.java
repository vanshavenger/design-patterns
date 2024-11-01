public class Main {
   public static void main(String[] args) {
        Application app = new Application(new WindowUiFactory());
        app.paint();
        Application app2 = new Application(new MacUIFactory());

        app2.paint();
    }
}