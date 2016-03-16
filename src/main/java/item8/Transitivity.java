package item8;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by evgen on 15.03.16.
 */
public class Transitivity {

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
        /**
         *
         */
        Date d1 = new Date(2015, 1, 1, 0, 0);
        Timestamp d2 = new Timestamp(2015, 1, 1, 0, 0, 0, 0);
        System.out.println(d1.equals(d2));
        System.out.println(d2.equals(d1));
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


class NewColorPoint {

    /**
     * Composition instead inheritance
     */
    private final Point point;
    private final Color color;

    public NewColorPoint(int x, int y, Color color) {
        if (color == null)
            throw new IllegalArgumentException();
        this.point = new Point(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof NewColorPoint))
            return false;
        NewColorPoint p = (NewColorPoint) obj;
        return p.point.equals(point) && p.color.equals(color);
    }
}
