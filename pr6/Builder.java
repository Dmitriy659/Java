package pr6;

class BuilderProduct {
    String part1;
    String part2;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }
    void construct() {
        builder.BuildPart1();
        builder.BuildPart2();

    }

    interface Builder {
        void BuildPart1();
        void BuildPart2();
        BuilderProduct getResult();

    }
}

class ConcreateBuilder implements Director.Builder {

    private BuilderProduct pr = new BuilderProduct();
    @Override
    public void BuildPart1() {
        pr.setPart1("Part1 created");
    }

    @Override
    public void BuildPart2() {
        pr.setPart2("Part2 created");
    }

    @Override
    public BuilderProduct getResult() {
        return pr;
    }
}

