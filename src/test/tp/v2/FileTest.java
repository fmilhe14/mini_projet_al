package tp.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileTest {
    @Test
    void representation_vide() {
        File<Integer> vide = new FileMutableParListeMutable<>();
        assertEquals(vide.representation(), "[]");
    }

    @Test
    void representation_non_vide() {
        File<Integer> toTest = new FileMutableParListeMutable<>(
                ListeMutable.cons(1, ListeMutable.cons(2, ListeMutable.vide())),
                ListeMutable.cons(3, ListeMutable.vide())
        );
        assertEquals(toTest.representation(), "[1, 2, 3]");
    }
}