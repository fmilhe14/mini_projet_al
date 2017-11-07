package tp.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by francoismilhem on 07/11/2017.
 */
class FileImmutableParListeTest {


    @Test
    void premier_si_fin_non_vide() {

        FileImmutableParListe<Integer> f = new FileImmutableParListe<>(Liste.cons(1, Liste.vide()),
                Liste.vide());

        assertEquals(1, (int)f.premier());

    }

    @Test
    void suivants() {

        FileImmutableParListe<Integer> f = new FileImmutableParListe<>(Liste.cons(1, Liste.vide()),
                ListeMutable.vide());

        f = (FileImmutableParListe<Integer>) f.ajout(2);

        FileImmutableParListe suivants = (FileImmutableParListe)f.suivants();
        FileImmutableParListe suivantDeSuivants = (FileImmutableParListe)suivants.suivants();

        assertEquals(2, (int)suivants.premier());
        assertEquals(true, suivantDeSuivants.getListe().casVide());
        assertEquals(true, suivantDeSuivants.getFin().casVide());


    }

    @Test
    void taille() {

        FileImmutableParListe<Integer> f = new FileImmutableParListe<>(Liste.cons(1, Liste.vide()),
                ListeMutable.vide());

        assertEquals(1, f.taille());

        f = (FileImmutableParListe<Integer>) f.ajout(2);

        assertEquals(2, f.taille());


    }


    @Test
    void ajout() {

        FileImmutableParListe<Integer> f = new FileImmutableParListe<>(Liste.cons(1, Liste.vide()),
                ListeMutable.vide());

        f = (FileImmutableParListe<Integer>) f.ajout(2);

        FileImmutableParListe suivants = (FileImmutableParListe)f.suivants();
        FileImmutableParListe suivantDeSuivants = (FileImmutableParListe)suivants.suivants();

        assertEquals(2, (int)suivants.premier());
        assertEquals(true, suivantDeSuivants.getListe().casVide());
        assertEquals(true, suivantDeSuivants.getFin().casVide());

    }

    @Test
    void retrait() {

    }

    @Test
    void ajout1() {

    }

    @Test
    void iterator() {

    }

}