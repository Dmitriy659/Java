package pr6;

interface Prototype {
    Prototype clone();
}

class ConcreatePrototype1 implements Prototype {

    @Override
    public Prototype clone() {
        return new ConcreatePrototype1();
    }
}

class ConcreatePrototype2 implements Prototype {

    @Override
    public Prototype clone() {
        return new ConcreatePrototype2();
    }
}
