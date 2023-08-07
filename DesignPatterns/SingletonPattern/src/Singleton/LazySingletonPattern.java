package Singleton;

//lazy singleton instantiation is not thread safe
public class LazySingletonPattern {
    private static LazySingletonPattern lazyObj;

    //private constructor to force use of
    //getInstance() to create object
    private LazySingletonPattern() {
    }

    public static LazySingletonPattern getInstance() {
        if(lazyObj == null) {
            lazyObj = new LazySingletonPattern();
            System.out.println("lazy Obj initialized");
        }
        return lazyObj;
    }
}
