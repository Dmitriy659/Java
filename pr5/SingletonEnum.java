package pr5;

public enum SingletonEnum {
    INSTANCE;
    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}

