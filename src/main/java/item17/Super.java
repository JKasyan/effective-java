package item17;

import java.util.Date;
import java.util.Map;

/**
 * Created by evgen on 17.03.16.
 */
public class Super {

    protected Super() {
        overrideMe();
    }

    public void overrideMe() {}
}

class Sub extends Super {

    private final Date date;

    public Sub(Date date) {
        this.date = date;
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }
}

class Main {

    public static void main(String[] args) {
        Sub sub = new Sub(new Date());
        sub.overrideMe();
    }
}
