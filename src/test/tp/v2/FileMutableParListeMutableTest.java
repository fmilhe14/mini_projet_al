package tp.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by francoismilhem on 06/11/2017.
 */
class FileMutableParListeMutableTest {

    @Test
    void premier_si_fin_non_vide() {

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.cons(1, ListeMutable.vide()),
                ListeMutable.vide());

        assertEquals(1, (int)f.premier());

        f.ajouter(2);

        assertEquals(1, (int)f.premier());


    }

    @Test
    void premier_si_fin_vide_mais_pas_la_liste() {

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.vide(),
                ListeMutable.cons(1, ListeMutable.vide()));

        assertEquals(1, (int)f.premier());

        f.ajouter(2);

        assertEquals(1, (int)f.premier());

    }

    @Test
    void ajouter_un_terme_avec_la_fin_non_vide() {

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.cons(1, ListeMutable.vide()),
                ListeMutable.vide());

        f.ajouter(2);

        assertEquals(2, f.taille());
        assertEquals(1, f.getListe().taille());

    }


    @Test
    void ajouter_integer_à_une_liste_vide(){

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.vide(),
                ListeMutable.vide());


       f.ajouter(2);

        assertEquals(1, f.taille());
        assertEquals(1, f.getListe().taille());
    }

    @Test
    void retirer() {

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.cons(1, ListeMutable.vide()),
                ListeMutable.vide());


        f.retirer();

        assertEquals(0, f.taille());

    }

    @Test
    void retirer_à_une_liste_vide() {

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.vide(), ListeMutable.vide());

        Executable executable = () -> f.retirer();

        assertThrows(UnsupportedOperationException.class, executable);


    }

    @Test
    void retirer_et_verifier_que_la_liste_est_vide(){

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.vide(),
                ListeMutable.vide());

        f.ajouter(1);
        f.ajouter(2);

        f.retirer();

        assertEquals(0, f.getListe().taille());
        assertEquals(1, f.taille());
        assertEquals(2, (int)f.premier());

    }


    @Test
    void iterator() {

        FileMutableParListeMutable<Integer> f = new FileMutableParListeMutable(ListeMutable.vide(),
                ListeMutable.vide());

        f.ajouter(1);
        f.ajouter(2);

        Iterator<Integer> iterator = f.iterator();

        assertEquals(1, (int)iterator.next());
        assertEquals(2, (int)iterator.next());
        assertEquals(false, iterator.hasNext());
        assertEquals(2, f.taille());


    }



}