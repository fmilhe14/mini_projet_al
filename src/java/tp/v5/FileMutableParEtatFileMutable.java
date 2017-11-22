package tp.v5;

import java.util.Iterator;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public class FileMutableParEtatFileMutable<E> implements EtatFileMutable<E> {

    private ListeMutable<E> listeMutable;

    public FileMutableParEtatFileMutable(ListeMutable listeMutable){

        this.listeMutable = listeMutable;
    }

    @Override
    public int taille() {
        return this.listeMutable.taille();
    }

    @Override
    public E premier() {
        return this.listeMutable.tete();
    }

    @Override
    public EtatFileMutable<E> creer() {
        return new FileMutableParEtatFileMutable<E>(this.listeMutable);
    }

    @Override
    public EtatFileMutable<E> ajout(E dernierDansFile) {
        this.listeMutable.changerTete(dernierDansFile);
        return this;
    }

    @Override
    public EtatFileMutable<E> retrait() {

        ListeMutable<E> copie = ListeMutable.cons(this.listeMutable.tete(), this.listeMutable.reste());

        copie.changerTete(copie.reste().tete());
        copie.changerReste(copie.reste().reste());
        return new FileMutableParEtatFileMutable<>(copie) ;

    }


    @Override
    public EtatFileMutable<E> creerCopie() {
        return new FileMutableParEtatFileMutable<E>(this.listeMutable);
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}
