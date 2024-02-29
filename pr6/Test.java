package pr6;

public class Test {
    public static void main(String[] args) {
        ConcreateCreator obj = new ConcreateCreator();
        System.out.println(obj.factoryMethod().getClass());

        ConcreateFactory obj1 = new ConcreateFactory();
        System.out.println(obj1.createProductA().getClass() + "\n" + obj1.createProductB().getClass());

        Director.Builder builder = new ConcreateBuilder();
        Director director = new Director(builder);
        director.construct();
        BuilderProduct res = builder.getResult();
        System.out.println(res.getClass());

        Prototype obj2 = new ConcreatePrototype1();
        Prototype obj3 = obj2.clone();
        System.out.println(obj2.getClass() + " " + obj3.getClass());
        Prototype obj4 = new ConcreatePrototype2();
        Prototype obj5 = obj4.clone();
        System.out.println(obj4.getClass() + " " + obj5.getClass());
    }
}
