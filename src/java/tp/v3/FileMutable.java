package tp.v3;

public interface FileMutable<E> extends File<E> {

    /*
     * Accesseurs
     */
    @Override
    default FileMutable<E> suivants() {
        FileMutable<E> copie = this.creerCopie();
        copie.retirer();
        return copie;
    }

    /**
     * ajoute l'élément en paramètre en dernière position de la File
     *
     * @param element
     */
    void ajouter(E element);

    /**
     * Retire le premier élément de la File
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

        FileMutable<E> copie = this.creerCopie();
        copie.ajouter(dernierDansFile);
        return copie;
    }

    @Override
    default FileMutable<E> retrait() {
        FileMutable<E> copie = this.creerCopie();
        copie.retirer();
        return copie;
    }

    /**
     * Complexité en O(|secondeFile|)
     *
     * @param secondeFile les éléments à ajouter à this
     * @return
     */
    @Override
    default FileMutable<E> ajout(File<E> secondeFile) {

        FileMutable<E> copie = this.creerCopie();

        while (!secondeFile.estVide()) {
            copie.ajout(secondeFile.retrait().premier());
        }
        return copie;
    }

    /**
     * Complexité en O(1)
     *
     * @param secondeFile les éléments à ajouter à this
     * @return this à laquelle sont ajoutés les séléments du paramètre secondeFile
     */
    void ajouter(File<E> secondeFile);

}
