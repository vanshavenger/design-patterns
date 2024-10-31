public class Window extends OperatingSystem {

    public Window(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        System.out.println("using WINDOWS: Changing directory to " + dir);
    }

    @Override
    public void removeDir(String file) {
        System.out.println("using WINDOWS: Removing directory " + file);
    }
    
}
