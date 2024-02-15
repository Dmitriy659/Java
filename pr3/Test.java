package pr3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Integer> innerSet = new HashSet<>();
        Set<Integer> synchronizedSet = new SychronizedSet<>(innerSet);

        synchronizedSet.add(1);
        synchronizedSet.add(2);
        synchronizedSet.add(3);

        synchronizedSet.remove(2);

        System.out.println(synchronizedSet + ", size: " + synchronizedSet.size());

        Map<Integer, String> innerMap = new HashMap<>();
        Map<Integer, String> lockMap = new LockMap<>(innerMap);

        lockMap.put(1, "One");
        lockMap.put(2, "Two");
        lockMap.put(3, "Three");
        lockMap.remove(2);

        System.out.println(lockMap + ", size: " + lockMap.size());
    }
}
