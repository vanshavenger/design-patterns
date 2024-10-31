// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        try {
            // example();
            example2();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    // private static void example() throws IOException, ClassNotFoundException {
    //     // LazySingleton lazySingleton = LazySingleton.getInstance();
    //     // ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
    //     // objectOutputStream.writeObject(lazySingleton);
    //     // objectOutputStream.close();

    //     // ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));
    //     // LazySingleton lazySingleton2 = (LazySingleton) objectInputStream.readObject();
    //     // objectInputStream.close();

    //     // System.out.println(lazySingleton.hashCode());
    //     // System.out.println(lazySingleton2.hashCode());

    //     SeriazableSingleton seriazableSingleton = SeriazableSingleton.getInstance();
    //     ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object1.txt"));
    //     objectOutputStream.writeObject(seriazableSingleton);
    //     objectOutputStream.close();

    //     ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object1.txt"));
    //     SeriazableSingleton seriazableSingleton2 = (SeriazableSingleton) objectInputStream.readObject();
    //     objectInputStream.close();

    //     System.out.println(seriazableSingleton.hashCode());
    //     System.out.println(seriazableSingleton2.hashCode());

    // }
    
    private static void example2() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        System.out.println(lazySingleton.hashCode());
        System.out.println(lazySingleton2.hashCode());

        EnumSingleton.INSTANCE.doSomething();
    }

}