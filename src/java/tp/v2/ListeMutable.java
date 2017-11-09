package tp.v2;

import java.util.Iterator;

public interface ListeMutable<E> extends Liste<E> {


    // Accesseurs

    /**
     * @param <E> Le type des elements de la liste
     * @return Une liste vide
     */
    public static <E> ListeMutable<E> vide() {
        return new ListeMutable<E>() {

            @Override
            public boolean casVide() {
                return true;
            }
        };
    }

    /**
     * Remplace le reste de la liste par la liste donnée en argument
     *
     * @param reste la liste a concaténer a la fin de this.
     */
    default void changerReste(ListeMutable<E> reste) {
        throw new UnsupportedOperationException();
    }

    /**
     * Remplace la tête de la liste par l'élément donné en argument
     *
     * @param tete la nouvelle tete de la liste
     */
    default void changerTete(E tete) {
        throw new UnsupportedOperationException();
    }

    // Services

    /**
     * @return une liste mutable d'éléments de type E
     */
    default ListeMutable<E> reste() {
        throw new UnsupportedOperationException();
    }

    // Fabriques (statiques)

    /**
     * @return Une copie de this dont la position des elements est inversee
     */
    default ListeMutable<E> miroir() {

        Iterator<E> iterator = this.iterator();

        if (iterator.hasNext()) {

            ListeMutable<E> miroir = ListeMutable.cons(iterator.next(), ListeMutable.vide());

            while (iterator.hasNext()) {

                miroir.changerTete(iterator.next());
            }

            return miroir;
        }

        return ListeMutable.vide();
    }

    /**
     * @param t la tete de la liste
     * @param r le reste de la liste
     * @param <E> Le type des elements de la liste
     * @return Une liste dont la tête est le premier parametre t, et dont le reste est le second parametre r.
     */
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

                this.changerReste(ListeMutable.cons(this.tete, this.reste));
                this.tete = tete;

            }

            @Override
            public boolean casCons() {
                return true;
            }
        };
    }

}
