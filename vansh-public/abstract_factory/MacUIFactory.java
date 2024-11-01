public class MacUIFactory implements  UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Panel createPanel() {
        return new MacPanel();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
    
}
