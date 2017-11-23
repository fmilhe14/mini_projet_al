package tp.v5;

/**
 * Created by francoismilhem on 23/11/2017.
 */
public class FileImmutableParEtatFileImmutable<E> {

    private EtatFileImmutable<E> etatFileImmutable;

    public FileImmutableParEtatFileImmutable(EtatFileImmutable etatFileImmutable){

        this.etatFileImmutable = etatFileImmutable;
    }

    public E premier(){

        return etatFileImmutable.premier();
    }

    public EtatFileImmutable suivants(){

        return etatFileImmutable.suivants();
    }

    public EtatFileImmutable creer(){

        return etatFileImmutable.creer();
    }


    public EtatFileImmutable ajout(E dernierDansFile){

        this.etatFileImmutable =  etatFileImmutable.ajout(dernierDansFile);
        return this.etatFileImmutable;
    }

    public EtatFileImmutable retrait(){

        this.etatFileImmutable =  etatFileImmutable.suivants();
        return this.etatFileImmutable;
    }

    public int taille(){

        return etatFileImmutable.taille();
    }
}
