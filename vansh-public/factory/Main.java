public class Main {
    public static void main(String[] args) {
        OperatingSystem windows = OperatingSystemFactory.getInstance("WINDOWS", "10", "64-bit");
        OperatingSystem linux = OperatingSystemFactory.getInstance("LINUX", "Ubuntu", "64-bit");
        
        windows.changeDir("C:\\Users\\user\\Desktop");
        windows.removeDir("C:\\Users\\user\\Desktop\\file.txt");
        
        linux.changeDir("/home/user/Desktop");
        linux.removeDir("/home/user/Desktop/file.txt");
    }
}
