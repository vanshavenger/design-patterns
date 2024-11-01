public class WindowUiFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public Panel createPanel() {
        return new WindowPanel();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowCheckbox();
    }
    
}
