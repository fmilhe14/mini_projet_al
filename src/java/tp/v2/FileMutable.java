package tp.v2;

public interface FileMutable<E> extends File<E> {

	/*
	 * Accesseurs
	 */
	@Override
	default FileMutable<E> suivants(){
		// TODO
		return null;
	}

	void ajouter(E element);
	void retirer();
	
	/*
	 * Fabriques
	 */
	FileMutable<E> creer();
	FileMutable<E> creerCopie();
	
	/*
	 * Services
	 */
	@Override
	default FileMutable<E> ajout(E dernierDansFile) {
		// TODO

		this.suivants().ajouter(dernierDansFile);
		return this;

	}
	@Override
	default FileMutable<E> retrait() {
		// TODO
		return this.suivants();
	}
	// Complexité O(|secondeFile|)
	@Override
	default FileMutable<E> ajout(File<E> secondeFile) {
		// TODO (même code que FileImmutable.ajout)
		FileMutable<E> r = this;
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}

	
	// Complexité en O(1).
	void ajouter(File<E> secondeFile);

}
