package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 * Interface représentant les propriétés d'une file immutable.
 * @param <E> le type des éléments de la file.
 */
public interface FileImmutable<E> extends File<FileImmutable<E>, E>, IdentifiableParIteration<FileImmutable<E>, E>, RepresentableParIteration<E> {

    /**
     * Fabrique.
     *
     * @param dernier
     * @return une copie de this à laquelle l'élément en paramètre est ajouté en dernière position.
     */
    FileImmutable<E> creer(E dernier);

    /**
     * @return une copie de this sans son premier élément.
     */
    default FileImmutable<E> retrait(){

        return this.suivants();
    }

    /**
     * @param dernier
     * @return une copie de this à laquelle l'élément en paramètre est ajouté en dernière position.
     */
    default FileImmutable<E> ajout(E dernier){

        return this.creer(dernier);
    }

}
