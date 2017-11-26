package tp.v5;

public interface ListeMutable<E> extends 
	Liste<ListeMutable<E>, E>,
	IdentifiableParIteration<ListeMutable<E>, E>,
	RepresentableParIteration<E>
{

	// Accesseurs.

	/**
	 * Fabrique.
	 * @param <E> le type des éléments de la liste.
	 * @return une liste mutable vide.
	 */
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			@Override
			public boolean casVide(){
				return true;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeMutable))
					return false;
				ListeMutable<E> l = (ListeMutable<E>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}

		};
	}

	/**
	 * Fabrique.
	 *
	 * @param t   l'élément en tête de la liste.
	 * @param r   les autres éléments de la liste.
	 * @param <E> le type des éléments de la liste.
	 * @return une liste ayant t pour premier élément et r pour reste.
	 */
	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r) {
		return new ListeMutable<E>() {
			private E tete = t;
			private ListeMutable<E> reste = r;
			private int taille = r.taille() + 1;

			@Override
			public boolean casCons(){
				return true;
			}

			public E tete() {
				return this.tete;
			}

			public ListeMutable<E> reste() {
				return this.reste;
			}

			@Override
			public int taille() {
				return this.taille;
			}

			@Override
			public void changerTete(E tete) {
				this.tete = tete;
			}

			@Override
			public void changerReste(ListeMutable<E> reste) {
				this.reste = reste;
			}

			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeMutable<?>))
					return false;
				ListeMutable<E> l = (ListeMutable<E>)obj;
				return this.estEgal(l);
			}

			@Override
			public String toString() {
				return this.representation();
			}
		};
	}

	// Fabriques.

	@Override
	default ListeMutable<E> creer() {
		return vide();
	}

	@Override
	default ListeMutable<E> creer(E e) {
		return cons(e, this);
	}

	/**
	 * Concatène la liste en paramère à this.
	 *
	 * @param reste
	 */
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajoute l'élément en paramètre en tête de this.
	 *
	 * @param tete
	 */
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}


}
