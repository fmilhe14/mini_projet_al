package tp.v2;

public interface File<E> extends Iterable<E> {

    // Accesseurs

    /**
     * @return Le premier element de la liste
     */
    E premier();

    /**
     * @return tous les elements de la liste sauf le premier
     */
    File<E> suivants();

    /**
     * @return true ssi la liste est vide
     */
    default boolean estVide() {
        return this.taille() == 0;
    }

    /**
     * @return le nombre d'elements dans la liste
     */
    int taille();


    // Fabriques

    /**
     * @return une file vide
     */
    File<E> creer();


    // Services

    /**
     * @param dernierDansFile l'element a ajouter en queue de file
     * @return la File this a laquelle l'element dernierDansFile a ete ajoute en derniere position
     */
    File<E> ajout(E dernierDansFile);

    /**
     * @return this sans son premier element
     */
    File<E> retrait();

    /**
     * Complexité O(|secondeFile|)
     *
     * @param secondeFile les elements a ajouter a this
     * @return this a laquelle sont ajoutes les selements du parametre secondeFile
     */
    File<E> ajout(File<E> secondeFile);

    /**
     * @return Une chaine de caracteres lisible par l'homme representant la liste
     */
    default String representation() {
        StringBuilder res = new StringBuilder("[ ");
        res.append(this.premier().toString()).append(" ,");

        File<E> suivants = this.suivants();

        while (!suivants.estVide()) {
            res.append(suivants.premier()).append(" ,");
        }

        return res
                .append(suivants.premier())
                .append(" ]")
                .toString();
    }

    /**
     * @param file la file a comparer a this
     * @return true ssi this est egal au parametre file
     */
    default boolean estEgal(File<E> file) {

        if (this.taille() == file.taille()) {

            boolean estEgal = this.premier() == file.premier();

            File<E> suivants = this.suivants();

            while (estEgal && !this.estVide()) {

                suivants = suivants.suivants();
                file = file.retrait();

                estEgal = this.premier() == file.premier();

            }
            return estEgal;
        }
        return false;
    }


}