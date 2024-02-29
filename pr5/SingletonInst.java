package pr5;

public class SingletonInst {
    private static SingletonInst instance;

    private SingletonInst() {};
    public static synchronized SingletonInst getInstance() {
        if(instance == null) {
            instance = new SingletonInst();
            return instance;
        }
        return instance;
    }
}

