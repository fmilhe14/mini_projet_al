package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 * @param <E> Le type des éléments de la file mutable.
 */
public interface EtatFileMutable<E> extends EtatFile<EtatFileMutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E>  {

    /**
     * Ajoute à this l'élément en paramètre.
     *
     * @param element
     */
    default void ajouter(E element){
        this.ajout(element);
    }

    /**
     * Retire à this son premier élément.
     */
    default void retirer(){

        this.retirer();
    }

    @Override
    default EtatFileMutable<E> suivants(){

        EtatFileMutable<E> copie = this.creerCopie();
        copie.retrait();
        return copie ;
    }

    /**
     * @return Une copie de this.
     */
    EtatFileMutable<E> creerCopie();

}
