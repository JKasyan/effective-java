package chapter_2.item1;

/**
 * Created by evgen on 15.03.16.
 */
public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    private Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public static Person person(String lastName, String firstName, int age) {
        return new Person(lastName, firstName, age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

class Main {

    public static void main(String[] args) {
        Person person = Person.person("John", "Smith", 30);
        System.out.println(person);
    }
}
