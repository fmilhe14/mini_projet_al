package tp.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by francoismilhem on 05/11/2017.
 */
class ListeMutableTest {

    @Test
    void cons() {

        ListeMutable<Integer> l = ListeMutable.cons(1, ListeMutable.cons(1, ListeMutable.vide()));

        l.changerTete(2);

        Assertions.assertEquals(2,(int)l.tete());
        Assertions.assertEquals(1,(int)l.reste().tete());
        Assertions.assertEquals(2, l.taille());

    }

    @Test
    void vide() {


        ListeMutable<Integer> l = ListeMutable.vide();


        Assertions.assertEquals(0,l.taille());
    }

}