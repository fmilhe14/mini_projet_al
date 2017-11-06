package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}

	/**
	 * @return L'élément de tête de la file
	 */
	default E tete() {
		throw new UnsupportedOperationException();
	}

    /**
     * @return Tous les éléments de la file sauf la tête
     */
	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}

    /**
     * @return true ssi la liste a été créée avec la fabrique
     */
	default boolean casCons() {
		return false;
	}

    /**
     * @return le nombre d'éléments contenus dans la liste
     */
	default public int taille() {
		return 0;
	}

    /**
     * @return true ssi la liste est vide
     */
	default public boolean estVide() {
		return this.taille() == 0;
	}

	/*
	 * Services
	 */
	default Iterator<E> iterator() {
		// TODO
		return new IterateurListe<E>(this); // Compléter puis utiliser IterateurListe.
	}

	default Liste<E> miroir() {
		// TODO
		return this;
	}

	/*
	 * Fabriques (statiques)
	 */
	public static <E> Liste<E> vide() {

		return new Liste<E>() {

			public boolean casVide() {
				return true;
			}

		};
	}

	public static <E> Liste<E> cons(E t, Liste<E> r) {
		return new Liste<E>() {

			public boolean casCons() {
				return true;
			}

			@Override
			public E tete() {
				return t;
			}

			@Override
			public Liste<E> reste() {
				return r;
			}

			@Override
			public int taille() {

				if (t != null) {

					int taille = 1;
					Iterator<E> iterator = this.iterator();

					while (iterator.hasNext()) {

						taille++;

					}

					return taille;
				}

				return 0;
			}


		};

	}
}
