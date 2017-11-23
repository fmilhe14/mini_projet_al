package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface EtatFileImmutable<E>  extends File<EtatFileImmutable<E>, E>, IdentifiableParIteration<FileImmutable<E>, E>, RepresentableParIteration<E>  {

    EtatFileImmutable<E> creer(E dernier);

    default EtatFileImmutable<E> retrait(){

        return this.suivants();
    }

    default EtatFileImmutable<E> ajout(E dernier){

        return this.creer(dernier);
    }
}
