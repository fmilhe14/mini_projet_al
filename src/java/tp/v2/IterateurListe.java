package tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

	private Liste<E> liste;

	public IterateurListe(Liste liste){

		this.liste = liste ;
	}

	@Override
	public boolean hasNext() {
		return !liste.estVide();
	}

	@Override
	public E next() {
		E res = this.liste.tete();
		this.liste = this.liste.reste();

		return res ;
	}

}
