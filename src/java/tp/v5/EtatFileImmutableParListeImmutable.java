package tp.v5;

import java.util.Iterator;

/**
 * Created by francoismilhem on 23/11/2017.
 */
public class EtatFileImmutableParListeImmutable<E> implements EtatFileImmutable<E> {

    private ListeImmutable<E> listeImmutable;

    public EtatFileImmutableParListeImmutable(){

        this.listeImmutable = ListeImmutable.vide();
    }

    public EtatFileImmutableParListeImmutable(ListeImmutable listeImmutable){

        this.listeImmutable = listeImmutable;
    }

    @Override
    public int taille() {
        return this.listeImmutable.taille();
    }

    @Override
    public E premier() {
        return this.listeImmutable.tete();
    }

    @Override
    public EtatFileImmutable<E> suivants() {
        return new EtatFileImmutableParListeImmutable<E>(this.listeImmutable.miroir().reste());
    }

    @Override
    public EtatFileImmutable<E> creer() {
        return new EtatFileImmutableParListeImmutable<E>(this.listeImmutable);
    }

    @Override
    public EtatFileImmutable<E> creer(E dernier) {
        return new EtatFileImmutableParListeImmutable<E>(this.listeImmutable.creer(dernier));
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !listeImmutable.estVide();
            }

            @Override
            public E next() {

                E tete = listeImmutable.tete();
                listeImmutable = listeImmutable.reste();
                return tete;

            }
        };
    }
}
