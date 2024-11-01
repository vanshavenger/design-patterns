public class Application {
    private Button button;
    private Panel panel;
    private Checkbox checkbox;

    public Application(UIFactory factory) {
        button = factory.createButton();
        panel = factory.createPanel();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        panel.paint();
        checkbox.paint();
    }
}
