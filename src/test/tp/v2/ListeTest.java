package tp.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by francoismilhem on 06/11/2017.
 */
class ListeTest {

    @Test
    void miroir() {


        Liste<Integer> liste = Liste.cons(1, Liste.cons(2, Liste.cons(3, Liste.vide())));

        Liste<Integer> miroir = liste.miroir();

        assertEquals(3, (int)miroir.tete());
        assertEquals(2, (int)miroir.reste().tete());
        assertEquals(1, (int)miroir.reste().reste().tete());
        assertEquals(3, (int)miroir.taille());

    }

}