package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 * Interface représentant les propriétés d'une file mutable.
 * @param <E> le type des éléments de la file.
 */
public interface FileMutable<E> extends File<FileMutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E> {

    /**
     * Ajoute l'élément en paramètre à la file this.
     *
     * @param element
     */
    default void ajouter(E element){
        this.ajout(element);
    }

    /**
     * Contatène la file en paramètre à this.
     * @param file
     */
    void ajouter(FileMutable<E> file);

    /**
     * Retière la tête de this.
     */
    default void retirer(){

        this.retirer();
    }

    /**
     * @return une liste contenant tous les éléments de this sauf la tête.
     */
    default FileMutable<E> suivants(){

        FileMutable<E> copie = this.creerCopie();
        copie.retrait();
        return copie ;
    }

    /**
     * Fabrique.
     * @return une copie de this.
     */
    FileMutable<E> creerCopie();

}
