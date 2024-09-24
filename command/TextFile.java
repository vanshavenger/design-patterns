package command;

public class TextFile {
    private final String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String open() {
        return "Opening the file: " + this.name;
    }

    public String save() {
        return "Saving the file: " + this.name;
    }




    

}