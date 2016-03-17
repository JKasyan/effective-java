package item9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evgen on 16.03.16.
 */
public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "areaCode");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "lineNumber");
        this.areaCode = (short)areaCode;
        this.prefix = (short)prefix;
        this.lineNumber = (short)lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if(arg < 0 || arg > max)
            throw new IllegalArgumentException("name: " + name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if (!(obj instanceof PhoneNumber))
            return false;
        PhoneNumber p = (PhoneNumber) obj;
        return p.areaCode == areaCode
                && p.prefix == prefix
                && p.lineNumber == lineNumber;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + areaCode;
        result = result * 31 + prefix;
        result = result * 31 + lineNumber;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }

    @Override
    protected PhoneNumber clone() {
        try {
            return (PhoneNumber)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public int compareTo(PhoneNumber o) {
        if(areaCode > o.areaCode)
            return 1;
        if(areaCode < o.areaCode)
            return -1;
        if(prefix > o.prefix)
            return 1;
        if(prefix < o.prefix)
            return -1;
        if(lineNumber > o.lineNumber)
            return 1;
        if(lineNumber < o.lineNumber)
            return -1;
        return 0;
    }
}

class Main {

    public static void main(String[] args) {
        Map<PhoneNumber, String> numbers = new HashMap<>();
        numbers.put(new PhoneNumber(707, 867, 5309), "Jenny");
        numbers.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(new PhoneNumber(707, 867, 5309).hashCode());
        System.out.println(numbers);
        System.out.println(numbers.get(new PhoneNumber(707, 867, 5309)));
    }
}
