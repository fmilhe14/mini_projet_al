package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface EtatFileImmutable<E>  extends File<FileImmutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E>  {

    FileImmutable<E> creer(E dernier);

    default FileImmutable<E> retrait(){

        return this.suivants();
    }

    default FileImmutable<E> ajout(E dernier){

        return this.creer(dernier);
    }
}
