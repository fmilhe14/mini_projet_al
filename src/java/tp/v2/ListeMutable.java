package tp.v2;

import java.util.Iterator;

public interface ListeMutable<E> extends Liste<E> {


    // Accesseurs

    default ListeMutable<E> reste() {
        throw new UnsupportedOperationException();
    }
    /**
     * Remplace le reste de la liste par la liste donnée en argument
     * @param reste
     */
    default void changerReste(ListeMutable<E> reste) {
        throw new UnsupportedOperationException();
    }

    /**
     * Remplace la tête de la liste par l'élément donné en argument
     * @param tete la nouvelle tete de la liste
     */
    default void changerTete(E tete) {
        throw new UnsupportedOperationException();
    }

    default ListeMutable<E> miroir(){

        Iterator<E> iterator = this.iterator();

        if (iterator.hasNext()) {

            ListeMutable<E> miroir = ListeMutable.cons(iterator.next(), ListeMutable.vide());

            while (iterator.hasNext()) {

                miroir = ListeMutable.cons(iterator.next(), miroir);

            }

            return miroir ;
        }

        return ListeMutable.vide();
    }

    public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r) {

        return new ListeMutable<E>() {

            private ListeMutable<E> reste = r;
            private E tete = t;


            @Override
            public E tete() {
                return this.tete;
            }

            @Override
            public ListeMutable<E> reste() {
                return this.reste;
            }

            @Override
            public void changerReste(ListeMutable<E> reste) {

                this.reste = reste;
            }

            @Override
            public void changerTete(E tete) {

                this.tete = tete;
            }

            @Override
            public boolean casCons() {
                return true;
            }
        };
    }

    public static <E> ListeMutable<E> vide() {
        return new ListeMutable<E>() {

            @Override
            public boolean casVide() {
                return true;
            }
        };
    }

}
