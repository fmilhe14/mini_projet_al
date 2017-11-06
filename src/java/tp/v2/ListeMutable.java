package tp.v2;

import java.util.Iterator;

public interface ListeMutable<E> extends Liste<E> {

    // Accesseurs.

    /**
     * @return tous les éléments de la liste sauf la tête
     */
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
     * @param tete
     */
    default void changerTete(E tete) {
        throw new UnsupportedOperationException();
    }

    // Services

    default ListeMutable<E> miroir() {
        // TODO
        return this;
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

                this.reste = ListeMutable.cons(this.tete(), this.reste);

                this.tete = tete;
            }

            @Override
            public int taille() {

                if (t != null) {

                    int taille = 1;
                    Iterator<E> iterator = this.iterator();

                    while (iterator.hasNext()) {

                        iterator.next();
                        taille++;

                    }

                    return taille;
                }

                return 0;
            }
        };
    }

    public static <E> ListeMutable<E> vide() {
        return new ListeMutable<E>() {

        };
    }

}
