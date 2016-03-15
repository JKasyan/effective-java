package item8;

/**
 * Created by evgen on 15.03.16.
 */
public class Test {

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));
        System.out.println(p3.equals(p2));
        System.out.println(p1.equals(p3));
    }
}

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        Point p = (Point)obj;
        return p.x == x && p.y==y;
    }
}

enum  Color{
    RED, GREEN, BLUE
}

class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point))
            return false;
        /**
         * If obj is point
         */
        if (!(obj instanceof ColorPoint))
            return super.equals(obj);

        /**
         * Full compare when obj is ColorPrint
         */
        ColorPoint c = (ColorPoint) obj;
        return super.equals(obj) && c.color == color;
    }
}
