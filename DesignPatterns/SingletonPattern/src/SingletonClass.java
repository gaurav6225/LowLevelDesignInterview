public class SingletonClass {
    public static SingletonClass obj;
    private SingletonClass() {

    }
    public static SingletonClass getInstance() {
        if(obj == null) {
            synchronized (SingletonClass.class) {
                if(obj == null) {
                    obj = new SingletonClass();
                }
            }
        }
        return obj;
    }
}
