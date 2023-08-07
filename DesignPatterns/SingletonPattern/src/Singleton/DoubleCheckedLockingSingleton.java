package Singleton;

// Double-Checked locking is the best solution to create
// single instance of an object using Singleton Pattern
public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton obj;

    //make the constructor private
    private DoubleCheckedLockingSingleton() {

    }
    public static DoubleCheckedLockingSingleton getInstance() {
        if(obj == null) {
            //make thread safe
            synchronized (DoubleCheckedLockingSingleton.class) {
                // check again as multiple threads
                // can reach above step
                if(obj == null) {
                    obj = new DoubleCheckedLockingSingleton();
                    System.out.println("Double-Checked Locking Singleton Object initialized");
                }
            }
        }
        return obj;
    }
}
