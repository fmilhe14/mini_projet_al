package tp.v2;

public interface FileMutable<E> extends File<E> {

    /*
     * Accesseurs
     */
    @Override
    default FileMutable<E> suivants() {
        return this.suivants();
    }

    /**
     * ajoute l'élément en paramètre en dernière position de la File
     * @param element
     */
    void ajouter(E element);

    /**
     * Retire le dernier élément de la File
     */
    void retirer();

    // Fabriques

    @Override
    FileMutable<E> creer();

    /**
     * @return une copie de this
     */
    FileMutable<E> creerCopie();


    //Services

    @Override
    default FileMutable<E> ajout(E dernierDansFile) {
        this.ajouter(dernierDansFile);
        return this;
    }

    @Override
    default FileMutable<E> retrait() {
        this.retirer();
        return this;
    }

    /**
     * Complexité en O(|secondeFile|)
     *
     * @param secondeFile les éléments à ajouter à this
     * @return
     */
    @Override
    default FileMutable<E> ajout(File<E> secondeFile) {
        while (!secondeFile.estVide()) {
            this.ajout(secondeFile.retrait());
        }
        return this;
    }

    /**
     * Complexité en O(1)
     *
     * @param secondeFile les éléments à ajouter à this
     * @return this à laquelle sont ajoutés les séléments du paramètre secondeFile
     */
    void ajouter(File<E> secondeFile);

}
