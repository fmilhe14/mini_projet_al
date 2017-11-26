package tp.v5;

/**
 * Interface représentant un élément identifiable.
 *
 * @param <K> le type de l'élément ayant la propriété d'être identifiable.
 */
public interface Identifiable<K> {

    /**
     * @param autre
     * @return true si les éléments de this sont les mêmes que ceux de la liste donnée en paramètre.
     */
    boolean estEgal(K autre);

}
