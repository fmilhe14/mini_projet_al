package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface EtatFile<K extends EtatFile<K, E>, E> extends Iterable<E>, Mesurable {

    /**
     * @return Le premier élément de la file.
     */
    E premier();

    /**
     * @return tous les éléments de la file sauf le premier.
     */
    K suivants();

    /**
     * @return true ssi la file est vide.
     */
    default boolean estVide(){

        return this.taille() == 0 ;
    }

    /**
     * Fabrique d'une file vide.
     *
     * @return une file vide de type K.
     */
    K creer();

    @SuppressWarnings("unchecked")
    /**
     * @return this.
     */
    default K sujet(){
        return (K)this;
    }

    /**
     * @param dernierDansFile
     * @return la file this à laquelle l'élément en paramètre a été ajouté en dernière position.
     */
    K ajout(E dernierDansFile);

    /**
     * @return la file this à sans son premier élément.
     */
    K retrait();

    /**
     * Méthode recupérée dans la classe v3.File.
     * @param secondeFile
     * @return la file this à laquelle est concaténée la file en paramètre.
     */
    default K ajout(K secondeFile){

        K r = this.sujet();
        for(E e : secondeFile){
            r = r.ajout(e);
        }
        return r;
    }

}
