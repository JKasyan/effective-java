package chapter_2.item5;

import java.util.*;

/**
 * Created by evgen on 15.03.16.
 */
public class Person {

    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = calendar.getTime();
    }

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Bad practice
     */
    public boolean isBabyBoomer() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = calendar.getTime();
        return birthDate.compareTo(boomStart) >=0 && birthDate.compareTo(boomEnd) < 0;
    }

    /**
     * Good practice
     */
    public boolean isBabyBoomerGoodPractice() {
        return birthDate.compareTo(BOOM_START) >=0 && birthDate.compareTo(BOOM_END) < 0;
    }
}

class PerformanceTest {

    private static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        long badPerformanceStart = System.currentTimeMillis();
        for(int i = 0;i<SIZE;i++) {
            Person p = new Person(new Date());
            p.isBabyBoomer();
        }
        long badPerformanceFinish = System.currentTimeMillis();
        //
        long improvedPerformanceStart = System.currentTimeMillis();
        for(int i = 0;i<SIZE;i++) {
            Person p = new Person(new Date());
            p.isBabyBoomerGoodPractice();
        }
        long improvedPerformanceFinish = System.currentTimeMillis();
        System.out.println("First: " + (badPerformanceFinish - badPerformanceStart));
        System.out.println("Second: " + (improvedPerformanceFinish - improvedPerformanceStart));
    }
}

class IntegerTest {

    public static void main(String[] args) {
        /**
         * Difference between primitives and autoboxing objects
         */
        long start = System.currentTimeMillis();
        Long sumOne = 0L;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            sumOne += i;
        }
        long finish = System.currentTimeMillis();

        long st = System.currentTimeMillis();
        long sumTwo = 0L;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            sumTwo += i;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Long: " + (finish - start));
        System.out.println("long: " + (fin - st));
    }
}



