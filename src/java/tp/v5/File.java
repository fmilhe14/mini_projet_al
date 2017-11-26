package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 * Interface représentant un cas général de file.
 * @param <K> Le type de la file.
 * @param <E> Le type des éléments de la file.
 */
public interface File<K extends File<K, E>, E> extends Iterable<E>, Mesurable  {

    /**
     * @return le premier élément de this.
     */
    E premier();

    /**
     * @return la file this sans son premier élément.
     */
    K suivants();

    /**
     * @return true ssi this est vide.
     */
    default boolean estVide(){

        return this.taille() == 0 ;
    }

    /**
     * Fabrique.
     *
     * @return une file vide.
     */
    K creer();

    @SuppressWarnings("unchecked")
    default K sujet(){
        return (K)this;
    }

    /**
     * @param dernierDansFile
     * @return une copie de this ajoutée de l'élément en paramètre, en dernière position.
     */
    K ajout(E dernierDansFile);

    /**
     * @return une copie de this sans son premier élément.
     */
    K retrait();

    /**
     * Méthode recupérée dans la classe v3.File
     * @param secondeFile
     * @return une copie de this concaténée avec la file en paramètre.
     */
    default K ajout(K secondeFile){

        K r = this.sujet();
        for(E e : secondeFile){
            r = r.ajout(e);
        }
        return r;
    }

}
