package Singleton;

// after instantiation, we can allow parallel execution
// of getInstance method, but that is not possible in this scenario
public class SynchronizedSingletonPattern {
    private static SynchronizedSingletonPattern obj;

    // make the constructor private
    private SynchronizedSingletonPattern() {

    }
    public static synchronized SynchronizedSingletonPattern getInstance() {
        if(obj == null) {
            obj = new SynchronizedSingletonPattern();
            System.out.println("Synchronized object initialized");
        }
        return obj;
    }
}
