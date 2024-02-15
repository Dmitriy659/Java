package pr2;

import java.time.LocalDate;

public class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Age: " + age + ", firstName: " + firstName + ", lastname: " + lastName + ", date: " + birthDate + ", weight: " + weight;
    }
}
