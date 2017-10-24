import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by francoismilhem on 24/10/2017.
 */
class FileMutableTest {

    @Test
    void ajouter() {

        File file = new FileMutable<Integer>();

        file.ajouter(1);
        file.ajouter(2);


        assertEquals(1, file.tete());
        assertEquals(2, file.size());

    }

    @Test
    void tete() {
        File file = new FileMutable<Integer>();
        file.ajouter(1);
        assertEquals(1, file.tete());

    }

    @Test
    void retirer() {

        File file = new FileMutable<Integer>();

        file.ajouter(1);
        file.ajouter(2);
        file.ajouter(3);


        assertEquals(1, file.tete());
        assertEquals(file.tete(), file.retirer());
        assertEquals(2, file.tete());
        assertEquals(2, file.size());

    }

}