package tp.v3;

public interface FileImmutable<E> extends File<E> {

    // Accesseurs

    FileImmutable<E> suivants();


    // Fabriques

    FileImmutable<E> creer();

    FileImmutable<E> creer(E dernier);


    // Services

    @Override
    default FileImmutable<E> ajout(E dernierDansFile) {
        return this.creer(dernierDansFile);
    }

    @Override
    default FileImmutable<E> retrait() {
        return this.suivants();
    }

    /**
     * Complexité O(|secondeFile|)
     *
     * @param secondeFile les éléments à ajouter à this
     * @return La concaténation de secondeFile à this
     */
    @Override
    default FileImmutable<E> ajout(File<E> secondeFile) {
        for (E e : secondeFile) {
            this.ajout(e);
        }
        return this;
    }

}
