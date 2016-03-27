package chapter_6.item30;

/**
 * Created by evgen on 27.03.16.
 */
public enum ConstantSpecificMethod {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },

    TWICE("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    ConstantSpecificMethod(String type) {
        this.type = type;
    }

    private final String type;

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 4d;
        double y = 5d;
        for(ConstantSpecificMethod o:ConstantSpecificMethod.values()) {
            System.out.printf("%f %s %f = %f%n", x, o.type, y, o.apply(x, y));
        }
    }
}
