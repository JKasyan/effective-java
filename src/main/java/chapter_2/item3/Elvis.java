package chapter_2.item3;

import java.lang.reflect.Constructor;

/**
 * Created by evgen on 15.03.16.
 */
public class Elvis {

    private static final Elvis ELVIS = new Elvis();

    private Elvis() {
        if(ELVIS != null)
            throw new IllegalAccessError();
    }

    public static Elvis getInstance() {
        return ELVIS;
    }
}

enum EvlisEnum {

    ELVIS
}

class Main {

    public static void main(String[] args) throws Exception {
        Elvis elvis = Elvis.getInstance();
        Class<? extends Elvis> elvisClass = elvis.getClass();
        Constructor<?>[] constructors = elvisClass.getDeclaredConstructors();
        Constructor<?> con = constructors[0];
        con.setAccessible(true);
        Elvis elv;
        try {
            elv = (Elvis)con.newInstance();
            System.out.println(elv == elvis);
        }catch (Exception e) {
            System.out.println("Error");
        }
    }
}
