package chapter_4.item21;

import java.io.Serializable;

/**
 * Created by evgen on 18.03.16.
 */
public class Host {

    private int a = 5;

    private static class StringComparator implements Comparator<String>, Serializable {

        @Override
        public int compare(String t1, String t2) {
            return t1.length() - t2.length();
        }
    }

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StringComparator();


}
