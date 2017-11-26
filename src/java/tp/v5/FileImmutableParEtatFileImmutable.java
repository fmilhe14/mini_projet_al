package tp.v5;

/**
 * Created by francoismilhem on 23/11/2017.
 * Classe implémentant une file immutable
 * @param <E> le type des éléments de la file.
 */
public class FileImmutableParEtatFileImmutable<E> {

    private EtatFileImmutable<E> etatFileImmutable;

    /**
     * Constructeur pour une file non vide.
     *
     * @param etatFileImmutable
     */
    public FileImmutableParEtatFileImmutable(EtatFileImmutable etatFileImmutable){

        this.etatFileImmutable = etatFileImmutable;
    }

    /**
     * @return le premier élément de la file.
     */
    public E premier(){

        return etatFileImmutable.premier();
    }

    /**
     * @return l'état de la file this sans son premier élément.
     */
    public EtatFileImmutable suivants(){

        return etatFileImmutable.suivants();
    }

    /**
     * Fabrique.
     * @return l'état d'une file vide.
     */
    public EtatFileImmutable creer(){

        return etatFileImmutable.creer();
    }

    /**
     * @param dernierDansFile
     * @return l'état de this ajoutée de l'élément en paramètre, en dernière position.
     */
    public EtatFileImmutable ajout(E dernierDansFile){

        this.etatFileImmutable =  etatFileImmutable.ajout(dernierDansFile);
        return this.etatFileImmutable;
    }

    /**
     * @return l'état de this sans son premier élément.
     */
    public EtatFileImmutable retrait(){

        this.etatFileImmutable =  etatFileImmutable.suivants();
        return this.etatFileImmutable;
    }

    /**
     * @return le nombre d'éléments dans la file.
     */
    public int taille(){

        return etatFileImmutable.taille();
    }
}
