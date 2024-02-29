package pr5;

public class Test {
    public static void main(String[] args) {
        SingletonInst obj1 = SingletonInst.getInstance();
        SingletonInst obj2 = SingletonInst.getInstance();
        System.out.println("Синглтон с ленивой реализацией: " + (obj1 == obj1));

        SingletonEnum obj3 = SingletonEnum.INSTANCE;
        SingletonEnum obj4 = SingletonEnum.INSTANCE;
        System.out.println("Синглтон с enum: " + (obj3 == obj4));

        SingletonHolder obj5 = SingletonHolder.getInstance();
        SingletonHolder obj6 = SingletonHolder.getInstance();
        System.out.println("Синглтон со статическом классов: " + (obj5 == obj6));
    }
}
