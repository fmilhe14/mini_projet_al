package tp.v5;

import java.util.Iterator;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public class FileMutableParEtatFileMutable<E>  {

    private EtatFileMutable<E> etatFileMutable;

    public FileMutableParEtatFileMutable(EtatFileMutable etatFileMutable){


        this.etatFileMutable = etatFileMutable;
    }

    public E premier(){

        return etatFileMutable.premier();
    }

    public EtatFileMutable suivants(){

        return etatFileMutable.suivants();
    }

    public EtatFileMutable creer(){

        return etatFileMutable.creer();
    }


    public EtatFileMutable ajout(E dernierDansFile){

        this.etatFileMutable =  etatFileMutable.ajout(dernierDansFile);
        return this.etatFileMutable;
    }

    public EtatFileMutable retrait(){

        this.etatFileMutable =  etatFileMutable.retrait();
        return this.etatFileMutable;
    }

    public int taille(){

        return etatFileMutable.taille();
    }

}
