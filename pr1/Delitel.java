package pr1;

import java.util.List;
import java.util.function.Function;

public class Delitel implements Function<List<Integer>, Integer> {


    @Override
    public Integer apply(List<Integer> numbers) {
        return gcd(numbers.get(0), numbers.get(1));
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            }
            else {
                b %= a;
            }
        }
        return a + b;
    }
}
