package tp.v5;

import java.util.Iterator;

/**
 * Interface représentant les propriétés d'une liste.
 *
 * @param <K> le sous-type de liste représenté.
 * @param <E> le type des éléments de la liste.
 */
public interface Liste<K extends Liste<K, E>, E> extends Iterable<E>, Mesurable {

    // Accesseurs

    /**
     * @return true ssi la liste est vide.
     */
    default boolean casVide() {
        return false;
    }

    /**
     * @return le premier élément de la liste.
     */
    default E tete() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return une copie de this sans son premier élément.
     */
    default K reste() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return true ssi la liste est non-vide.
     */
    default boolean casCons() {
        return false;
    }

    /**
     * @return true ssi la liste est vide.
     */
    default public boolean estVide(){
        return this.taille() == 0;
    }

    @Override
    default public int taille(){
        return 0;
    }


    // Fabriques.

    /**
     * @return this.
     */
    @SuppressWarnings("unchecked")
    default K sujet(){
        return (K)this;
    }

    /**
     * Fabrique.
     * @return une liste vide.
     */
    K creer();

    /**
     * Fabrique.
     * @param e
     * @return une copie de this à laquelle l'élément en paramètre a été ajouté en dernière position.
     */
    K creer(E e);

    //Services

    @Override
    default Iterator<E> iterator() {
        return new IterateurListe<K, E>(this.sujet());
    }

    /**
     * @return une liste contenant tous les éléments de this en ordre inversé.
     */
    default K miroir(){
        K r = creer();
        for(E e : this){
            r = r.creer(e);
        }
        return r;
    }

}
