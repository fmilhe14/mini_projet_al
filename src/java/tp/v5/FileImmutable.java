package tp.v5;

import java.util.Iterator;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface FileImmutable<E> extends File<FileImmutable<E>, E>, IdentifiableParIteration<FileImmutable<E>, E>, RepresentableParIteration<E> {


    FileImmutable<E> creer(E dernier);

    default FileImmutable<E> retrait(){

        return this.suivants();
    }

    default FileImmutable<E> ajout(E dernier){

        return this.creer(dernier);
    }

}
