package Client;

import Singleton.DoubleCheckedLockingSingleton;
import Singleton.EagerSingletonPattern;
import Singleton.LazySingletonPattern;
import Singleton.SynchronizedSingletonPattern;

public class Main {
    public static void main(String args[]) {

        //TestCase-1 : initializing two lazy singleton objects
        LazySingletonPattern lazyObj1 = LazySingletonPattern.getInstance();
        LazySingletonPattern lazyObj2 = LazySingletonPattern.getInstance();

        //TestCase-2 : initializing two synchronized singleton objects
        SynchronizedSingletonPattern syncObj1 = SynchronizedSingletonPattern.getInstance();
        SynchronizedSingletonPattern syncObj2 = SynchronizedSingletonPattern.getInstance();

        //TestCase-3 : initializing two Eager singleton objects
        EagerSingletonPattern eagerObj1 = EagerSingletonPattern.getInstance();
        EagerSingletonPattern eagerObj2 = EagerSingletonPattern.getInstance();

        //TestCase-4 : initializing two Double-Checked Locking singleton Objects
        DoubleCheckedLockingSingleton lockObj1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton lockObj2 = DoubleCheckedLockingSingleton.getInstance();

    }
}
