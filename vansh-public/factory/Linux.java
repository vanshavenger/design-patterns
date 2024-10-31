public class Linux extends OperatingSystem {
    public Linux(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        System.out.println("using LINUX: Changing directory to " + dir);
    }

    @Override   
    public void removeDir(String file) {
        System.out.println("using LINUX: Removing directory " + file);
    }
    

}
