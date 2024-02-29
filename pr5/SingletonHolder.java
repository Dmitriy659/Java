package pr5;

public class SingletonHolder {
    private SingletonHolder() {

    }

    private static class InstanceHolder {
        private static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return InstanceHolder.INSTANCE;
    }
}

