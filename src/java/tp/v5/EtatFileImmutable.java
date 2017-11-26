package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 * @param <E> Le type des éléments de la file.
 */
public interface EtatFileImmutable<E>  extends File<EtatFileImmutable<E>, E>, IdentifiableParIteration<FileImmutable<E>, E>, RepresentableParIteration<E>  {

    /**
     * @param dernier
     * @return la file this ajoutée de l'élément en paramètre, en dernière position.
     */
    EtatFileImmutable<E> creer(E dernier);

    /**
     * @return la file this sans son premier élément.
     */
    default EtatFileImmutable<E> retrait(){

        return this.suivants();
    }

    /**
     * @param dernier
     * @return la file this ajoutée de l'élément en paramètre, en dernière position.
     */
    default EtatFileImmutable<E> ajout(E dernier){

        return this.creer(dernier);
    }
}
