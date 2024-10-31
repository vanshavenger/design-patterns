public class OperatingSystemFactory {

    private OperatingSystemFactory() {
    }
    
    public static OperatingSystem getInstance(String type, String version, String architecture) {
        switch (type) {
            case "WINDOWS" -> {
                return new Window(version, architecture);
            }
            case "LINUX" -> {
                return new Linux(version, architecture);
            }
            default -> throw new IllegalArgumentException("Invalid Operating System type");
        }
    }
    
}
