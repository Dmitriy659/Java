package pr2;

import java.util.Comparator;

public class NameComp implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Character.compare(o1.firstName.charAt(1), o2.firstName.charAt(1));
    }
}
