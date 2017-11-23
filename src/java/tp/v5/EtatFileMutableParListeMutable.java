package tp.v5;

import java.util.Iterator;

/**
 * Created by francoismilhem on 23/11/2017.
 */
public class EtatFileMutableParListeMutable<E> implements EtatFileMutable<E> {

    private ListeMutable<E> listeMutable;

    public EtatFileMutableParListeMutable(){

        this.listeMutable = ListeMutable.vide();
    }

    public EtatFileMutableParListeMutable(ListeMutable listeMutable){

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
        return new EtatFileMutableParListeMutable<E>();
    }

    @Override
    public EtatFileMutable<E> ajout(E dernierDansFile) {
        return new EtatFileMutableParListeMutable<E>(this.listeMutable.creer(dernierDansFile));
    }

    @Override
    public EtatFileMutable<E> retrait() {

        return new EtatFileMutableParListeMutable<E>(this.listeMutable.miroir().reste());
    }

    @Override
    public EtatFileMutable<E> creerCopie() {
        return new EtatFileMutableParListeMutable<E>(this.listeMutable);
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !listeMutable.estVide();
            }

            @Override
            public E next() {

                E tete = listeMutable.tete();
                listeMutable = ListeMutable.cons(listeMutable.reste().tete(), listeMutable.reste().reste());
                return tete;
            }
        };
    }
}
