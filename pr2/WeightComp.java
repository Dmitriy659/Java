package pr2;

import java.util.Comparator;

public class WeightComp implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.weight * o1.age, o2.weight * o2.age);
    }

}
