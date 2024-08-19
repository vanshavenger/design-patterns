package Singleton;
// vansh chopra - Design Patters - Singleton Pattern

public class Singleton {
   private static volatile Singleton instance;
   private final String data;

   // Private constructor to prevent instantiation
   private Singleton(String data) {
      this.data = data; // All our data is stored in this variable
      // Additional initialization logic
   }

   // Get the Singleton instance, initializing it if necessary
   public static Singleton getInstanceOrInitialize(String data) {
      Singleton result = instance;
      if (result == null) {
         synchronized (Singleton.class) { // Thread-safe initialization
            result = instance;
            if (result == null) {
               instance = result = new Singleton(data);
            }
         }
      }
      return result;
   }

   // Overloaded method to get the instance without re-initialization
   public static Singleton getInstance() {
      Singleton result = instance;
      if (result == null) {
         throw new IllegalStateException("Singleton is not initialized. Call getInstanceOrInitialize first.");
      }
      return result;
   }

   public String getData() {
      return data;
   }

   public static void main(String[] args) {
      // Singleton singleton1 = Singleton.getInstanceOrInitialize("My Singleton Data");

      // Singleton sameInstance = Singleton.getInstance();

      // System.out.println(singleton1 == sameInstance); 
      // System.out.println(sameInstance.getData());

      
      Runnable task = () -> {
            Singleton singleton = Singleton.getInstanceOrInitialize("My Singleton Data from Thread " + Thread.currentThread().getName() + Math.random());
            System.out.println("Thread " + Thread.currentThread().getName() + ": " + singleton.getData());
        };

        Thread[] threads = new Thread[30];
        for (int i = 0; i < 30; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 30; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Singleton finalInstance = Singleton.getInstance();
        System.out.println("Final Singleton data: " + finalInstance.getData());
   }
}
