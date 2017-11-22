package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface EtatFileMutable<E> extends EtatFile<EtatFileMutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E>  {

    default void ajouter(E element){

        this.ajout(element);
    }


    default void retirer(){

        this.retirer();
    }

    default EtatFileMutable<E> suivants(){

        EtatFileMutable<E> copie = this.creerCopie();
        copie.retrait();
        return copie ;
    }

    EtatFileMutable<E> creerCopie();

}
