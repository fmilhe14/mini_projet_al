package tp.v3;

public interface File<E> extends Iterable<E> {


    // Accesseurs

    E premier();

    File<E> suivants();

    default boolean estVide() {
        return this.taille() == 0;
    }

    int taille();


    // Fabriques

    /**
     * @return une file Mutable correspodant au cas d'implémentation demandé
     */
    File<E> creer();


    // Services

    /**
     * @param dernierDansFile l'élément à ajouter en queue de file
     * @return la File this à laquelle l'élément dernierDansFile a été ajouté en dernière position
     */
    File<E> ajout(E dernierDansFile);

    /**
     * @return this sans son premier élément
     */
    File<E> retrait();

    /**
     * @param secondeFile les éléments à ajouter à this
     * @return this à laquelle sont ajoutés les séléments du paramètre secondeFile
     */
    File<E> ajout(File<E> secondeFile);

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

    default boolean estEgal(File<E> file) {
        boolean estEgal = false;

        if (this.taille() == file.taille()) {

            estEgal = this.premier() == file.premier();

            File<E> suivants = this.suivants();

            while (estEgal && !this.estVide()) {

                suivants = suivants.suivants();
                file = file.retrait();

                estEgal = this.premier() == file.premier();

            }

            return estEgal;
        }

        return estEgal;
    }


}