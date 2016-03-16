package item11;

/**
 * Created by evgen on 16.03.16.
 */
public class Person implements Cloneable {

    private final int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Person clone() {
        Person person;
        try {
            person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Person))
            return false;
        Person p = (Person)obj;
        return p.age == age;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

class Main {

    public static void main(String[] args) {
        Person p1 = new Person(29);
        Person p2 = p1.clone();
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
    }
}
