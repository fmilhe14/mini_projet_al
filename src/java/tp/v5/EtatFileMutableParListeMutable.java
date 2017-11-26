package tp.v5;

import java.util.Iterator;

/**
 * Created by francoismilhem on 23/11/2017.
 * Classe implémentant l'état d'une file mutable par une liste mutable.
 * @param <E> Le type des éléments de la file.
 */
public class EtatFileMutableParListeMutable<E> implements EtatFileMutable<E> {

    private ListeMutable<E> listeMutable;

    /**
     * Constructeur file vide.
     */
    public EtatFileMutableParListeMutable(){

        this.listeMutable = ListeMutable.vide();
    }

    /**
     * Constructeur pour une file non vide.
     *
     * @param listeMutable
     */
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
