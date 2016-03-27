package chapter_4.item21;

/**
 * Created by evgen on 18.03.16.
 */
public class StringLengthComparator implements Comparator<String> {

    private StringLengthComparator(){}

    public static final Comparator<String> INSTANCE = new StringLengthComparator();

    @Override
    public int compare(String t1, String t2) {
        return t1.length() - t2.length();
    }
}
