package chapter_4.item15;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by evgen on 17.03.16.
 */
public class Complex {

    private final double re;
    private final double im;
    private transient final int hash;
    private transient static final Map<Integer, Complex> CASH = new ConcurrentHashMap<>();

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
        this.hash = hash(re, im);
        CASH.put(hash, this);
    }

    public double realPart() {
        return re;
    }

    public double imaginepart() {
        return im;
    }

    public static Complex newInstance(double re, double im) {
        return new Complex(re, im);
    }

    public Complex add(Complex c) {
        double reRes = this.re + c.re;
        double imRes = this.im + c.im;
        int hash = hash(reRes, imRes);
        Complex com = CASH.get(hash);
        if(com == null)
            return CASH.put(hash, new Complex(reRes, imRes));
        else
            return com;
    }

    public Complex subtract(Complex c) {
        double reRes = this.re - c.re;
        double imRes = this.im - c.im;
        int hash = hash(reRes, imRes);
        Complex com = CASH.get(hash);
        if(com == null)
            return CASH.put(hash, new Complex(reRes, imRes));
        else
            return com;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if(!(obj instanceof Complex))
            return false;
        Complex c = (Complex)obj;
        return Double.compare(this.re, c.re) == 0
                && Double.compare(this.im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    private int hash(double re, double im) {
        int result = 17 * 31 + hashDouble(re);
        result = result * 31 + hashDouble(im);
        return result;
    }

    private int hashDouble(double d) {
        long l = Double.doubleToLongBits(d);
        return (int)(l ^ (l >>> 32));
    }

    @Override
    public String toString() {
        return "Complex{re=" + re + ", im=" + im + "}";
    }
}

class Main {

    public static void main(String[] args) {
        Complex c1 = Complex.newInstance(1, 2);
        Complex c2 = Complex.newInstance(0, 0);
        Complex c3 = c1.subtract(c2);
        System.out.println(c3);
    }
}
