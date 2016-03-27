package chapter_3.item12;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by evgen on 17.03.16.
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal one = new BigDecimal("1.0");
        BigDecimal two = new BigDecimal("1.00");
        System.out.println(one.equals(two));
        System.out.println(one.compareTo(two));
        HashSet<BigDecimal> set = new HashSet<>();
        set.addAll(Arrays.asList(one, two));
        System.out.println(set);
        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(one, two));
        System.out.println(treeSet);
    }
}