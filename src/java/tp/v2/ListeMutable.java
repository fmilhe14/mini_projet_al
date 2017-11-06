package tp.v2;

public interface ListeMutable<E> extends Liste<E> {


    // Accesseurs

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
        };
    }

    public static <E> ListeMutable<E> vide() {
        return new ListeMutable<E>() {};
    }

}
