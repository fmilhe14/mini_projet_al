package tp.v2;

public interface FileMutable<E> extends File<E> {

    // Accesseurs

    @Override
    default FileMutable<E> suivants() {
        FileMutable<E> copie = this.creerCopie();
        copie.retirer();
        return copie;
    }

    /**
     * ajoute l'element en parametre en derniere position de la File
     * @param element l'element a ajouter en fin de liste
     */
    void ajouter(E element);

    /**
     * Retire le premier element de la File
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

    @Override
    default FileMutable<E> ajout(File<E> secondeFile) {

        FileMutable<E> copie = this.creerCopie();

        while (!secondeFile.estVide()) {
            copie.ajout(secondeFile.retrait().premier());
        }
        return copie;
    }

    /**
     * Complexite en O(1)
     *
     * @param secondeFile les elements a ajouter a this
     */
    void ajouter(File<E> secondeFile);

}
