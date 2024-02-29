package pr6;

interface AbstractFactory {
    Object createProductA();
    Object createProductB();
}

class ConcreateFactory implements AbstractFactory {

    @Override
    public ConcreateProduct2 createProductA() {
        return new ConcreateProduct2();
    }

    @Override
    public ConcreateProduct3 createProductB() {
        return new ConcreateProduct3();
    }
}

interface AbstractProduct {

}

class ConcreateProduct2 implements AbstractProduct {

}

class ConcreateProduct3 implements AbstractProduct {

}