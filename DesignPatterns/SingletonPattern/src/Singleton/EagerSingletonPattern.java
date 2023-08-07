package Singleton;

// in case of a DB connection Eager instantiation will
// always connect to the DB even if no client is using it
public class EagerSingletonPattern {
    private static EagerSingletonPattern obj = new EagerSingletonPattern();

    //make the constructor private
    private EagerSingletonPattern() {

    }
    public static EagerSingletonPattern getInstance() {
        return obj;
    }
}
