public class SeriazableSingleton {
    private static SeriazableSingleton instance = null;

    private SeriazableSingleton() {}
    
    public static SeriazableSingleton getInstance() {
        if (instance == null) {
            instance = new SeriazableSingleton();
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}
