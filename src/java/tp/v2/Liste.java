package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {

    // Accesseurs

    default boolean casVide() {
        return false;
    }

    /**
     * @param <E> Le type des elements de la liste
     * @return Une liste vide
     */
    public static <E> Liste<E> vide() {

        return new Liste<E>() {

            public boolean casVide() {
                return true;
            }

        };
    }

    /**
     * @param t   la tete de la liste
     * @param r   le reste de la liste
     * @param <E> Le type des elements de la liste
     * @return Une liste dont la tête est le premier parametre t, et dont le reste est le second parametre r.
     */
    public static <E> Liste<E> cons(E t, Liste<E> r) {
        return new Liste<E>() {

            public boolean casCons() {
                return true;
            }

            @Override
            public E tete() {
                return t;
            }

            @Override
            public Liste<E> reste() {
                return r;
            }
        };

    }

    /**
     * @return L'element de tête de la file
     */
    default E tete() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return Tous les elements de la file sauf la tête
     */
    default Liste<E> reste() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return true ssi la liste est vide
     */
    default public boolean estVide() {
        return this.taille() == 0;
    }


    // Services

    default Iterator<E> iterator() {
        return new IterateurListe<E>(this);
    }

    /**
     * @return true ssi la liste a ete creee avec la fabrique
     */
    default boolean casCons() {
        return false;
    }


    //  Fabriques (statiques)

    /**
     * @return le nombre d'elements contenus dans la liste
     */
    default int taille() {

        try {
            E tete = this.tete();
        } catch (UnsupportedOperationException e) {
            return 0;
        }

        int taille = 0;

        for (E e : this) {
            taille++;
        }

        return taille;
    }

    /**
     * @return Une liste possedant les mêmes elements que this, dans le sens inverse
     */
    default Liste<E> miroir() {

        Iterator<E> iterator = this.iterator();

        if (iterator.hasNext()) {

            Liste<E> miroir = Liste.cons(iterator.next(), Liste.vide());

            while (iterator.hasNext()) {

                miroir = Liste.cons(iterator.next(), miroir);

            }

            return miroir ;
        }

        return Liste.vide();
    }
}
