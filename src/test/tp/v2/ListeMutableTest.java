package tp.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by francoismilhem on 05/11/2017.
 */
class ListeMutableTest {

    @Test
    void cons() {

        ListeMutable<Integer> l = ListeMutable.cons(1, ListeMutable.cons(1, ListeMutable.vide()));

        l.changerTete(2);

        assertEquals(2, (int) l.tete());
        assertEquals(1, (int) l.reste().tete());
        assertEquals(3, l.taille());

    }

    @Test
    void vide() {
        ListeMutable<Integer> l = ListeMutable.vide();
        assertEquals(0, l.taille());
    }

}