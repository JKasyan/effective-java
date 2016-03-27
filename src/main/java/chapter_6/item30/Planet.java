package chapter_6.item30;

/**
 * Created by evgen on 27.03.16.
 */
public enum Planet {

    MERCURY(3.302e23, 2.439e6),
    VENUS(4.869e24, 6.052e6),
    EARTH(5.975e24, 6.378e6);

    private final double mass;
    private final double radius;
    private final double gravity;
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        gravity = G * mass / (radius * radius);
    }

    public double mass() {return mass;}
    public double radius() {return radius;}
    public double gravity() {return gravity;}

    public double weight(double mass) {
        return mass * gravity;
    }

}

class Main {

    public static void main(String[] args) {
        for(Planet p:Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.weight(90));
        }
    }
}
