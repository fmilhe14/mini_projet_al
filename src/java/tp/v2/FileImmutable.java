package tp.v2;

public interface FileImmutable<E> extends File<E> {

	// Accesseurs

	/**
	 * @return tous les elements de la liste sauf le premier
	 */
	FileImmutable<E> suivants();
	

	// Fabriques

	FileImmutable<E> creer();

	/**
	 * @param dernier l'element a ajouter en fin de liste
	 * @return Une nouvelle file a partir de this avec dernier pour element supplementaire
	 */
	FileImmutable<E> creer(E dernier);
	

	// Services

	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {
		return this.creer(dernierDansFile) ;
	}

	@Override
	default FileImmutable<E> retrait() {
		return this.suivants();
	}

	@Override
	default FileImmutable<E> ajout(File<E> secondeFile){
		for(E e : secondeFile){
			this.ajout(e);
		}
		return this;
	}

}
