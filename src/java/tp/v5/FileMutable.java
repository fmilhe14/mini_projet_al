package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface FileMutable<E> extends File<FileMutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E> {

    default void ajouter(E element){

        this.ajout(element);
    }

    void ajouter(FileMutable<E> file);

    default void retirer(){

        this.retirer();
    }

    default FileMutable<E> suivants(){

        FileMutable<E> copie = this.creerCopie();
        copie.retrait();
        return copie ;
    }

    FileMutable<E> creerCopie();

}
