public class TextFile {
    private String name;
    
    public TextFile(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public String open() {
        return "Opening file " + name;
    }
    
    public String save() {
        return "Saving file " + name;
    }
}