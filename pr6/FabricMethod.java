package pr6;

interface Product {
    void operation();
}

class ConcreateProduct implements Product {

    @Override
    public void operation() {
        System.out.println("Действие продукта");
    }
}

abstract class Creator {

    abstract Object factoryMethod();

}

class ConcreateCreator extends Creator {

    @Override
    ConcreateProduct factoryMethod() {
        return new ConcreateProduct();
    }
}
