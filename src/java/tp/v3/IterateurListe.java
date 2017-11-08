package tp.v3;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

    private Liste<E> liste;

    public IterateurListe(Liste liste) {
        this.liste = liste;
    }

    @Override
    public boolean hasNext() {
        try {
            E tete = this.liste.tete();
            return tete != null;
        } catch (UnsupportedOperationException e) {
            return false;
        }
    }

    @Override
    public E next() {

        E res = this.liste.tete();
        this.liste = this.liste.reste();

        return res;
    }

}
