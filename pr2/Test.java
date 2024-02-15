package pr2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Human a1 = new Human(18, "Ivan", "Prikolov", LocalDate.now(), 100);
        Human a2 = new Human(20, "Misha", "Kukurov", LocalDate.now(), 69);
        Human a3 = new Human(21, "Kolya", "Dubov", LocalDate.now(), 80);
        Human a4 = new Human(17, "Timofei", "sadgvsg", LocalDate.now(), 70);
        Human a5 = new Human(16, "Sanya", "cxvcxb", LocalDate.now(), 110);
        Human a6 = new Human(24, "Katya", "wqeu", LocalDate.now(), 120);

        List<Human> array = new ArrayList<>();
        array.add(a1);
        array.add(a2);
        array.add(a3);
        array.add(a4);
        array.add(a5);
        array.add(a6);

        System.out.println("Сортировка по второй букве имени:");
        List<Human> sortedBySecondLetter = array.stream()
                .sorted(new NameComp())
                .toList();
        sortedBySecondLetter.forEach(System.out::println);

        System.out.println("\nФильтрация по кратности веса:");
        List<Human> filterByWeight = sortedBySecondLetter.stream()
                .filter(human -> human.weight % 10 == 0)
                .toList();
        filterByWeight.forEach(System.out::println);

        System.out.println("\nФильтрация по произведению веса и возраста:");
        List<Human> sortedAgeWeight = filterByWeight.stream()
                .sorted(new WeightComp())
                .toList();
        sortedAgeWeight.forEach(System.out::println);

        long res = sortedAgeWeight.stream()
                .mapToLong(human -> human.weight)
                .reduce(1L, (a, b) -> a * b);

        System.out.println("\nПроизведение всех весов:");
        System.out.println(res);
    }
}
