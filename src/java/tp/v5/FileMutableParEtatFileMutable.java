package tp.v5;


/**
 * Created by francoismilhem on 22/11/2017.
 * Classe implémentant une file mutable par l'état d'une file mutable.
 * @param <E> le type des éléments de la file.
 */
public class FileMutableParEtatFileMutable<E>  {

    private EtatFileMutable<E> etatFileMutable;

    /**
     * Constructeur pour une file non vide.
     *
     * @param etatFileMutable la file représentant this.
     */
    public FileMutableParEtatFileMutable(EtatFileMutable etatFileMutable){

        this.etatFileMutable = etatFileMutable;
    }

    /**
     * @return le premier élément de this.
     */
    public E premier(){

        return etatFileMutable.premier();
    }

    /**
     * @return this sans son premier élément.
     */
    public EtatFileMutable suivants(){

        return etatFileMutable.suivants();
    }

    /**
     * Fabrique.
     * @return une file vide.
     */
    public EtatFileMutable creer(){

        return etatFileMutable.creer();
    }

    /**
     * @param dernierDansFile
     * @return une copie de this ajoutée de l'élément en paramètre, en dernière position.
     */
    public EtatFileMutable ajout(E dernierDansFile){

        this.etatFileMutable =  etatFileMutable.ajout(dernierDansFile);
        return this.etatFileMutable;
    }

    /**
     * @return une copie de this sans son premier élément.
     */
    public EtatFileMutable retrait(){

        this.etatFileMutable =  etatFileMutable.retrait();
        return this.etatFileMutable;
    }

    /**
     * @return le nombre d'éléments que content this.
     */
    public int taille(){

        return etatFileMutable.taille();
    }

}
