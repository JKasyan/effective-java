package chapter_6.item30;

/**
 * Created by evgen on 27.03.16.
 */
public enum Operation {

    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y) {
        switch (this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("Unknown operation: " + this);
    }
}
