package tp.v2;

import java.util.Iterator;

/**
 * Created by francoismilhem on 07/11/2017.
 */
public class FileImmutableParListe<E> implements FileImmutable<E> {


    private Liste<E> liste;
    private Liste<E> fin;

    public FileImmutableParListe(){

        this.liste = Liste.vide();
        this.fin = Liste.vide();
    }

    public FileImmutableParListe(Liste fin, Liste liste){

        this.liste = liste;
        this.fin = fin;
    }

    @Override
    public E premier() {

        if(this.fin.casCons()) {
            return this.fin.tete();
        }

        else {

            if(this.liste.casCons()){

                this.fin = this.liste;
                this.liste = ListeMutable.vide();

                return this.fin.tete();

            }

        }

        throw new UnsupportedOperationException();

    }

    @Override
    public FileImmutable<E> suivants() {

        if(!this.fin.casVide()){

            return new FileImmutableParListe<E>(this.fin.reste(), this.liste);
        }

        else {

            if(!this.liste.casVide()){

                this.fin = this.liste.miroir();
                this.liste = Liste.vide();
                return new FileImmutableParListe<E>(this.fin.reste(), this.liste);

            }

            return this.creer();

        }
    }

    @Override
    public FileImmutable<E> creer() {
        return new FileImmutableParListe<E>();
    }

    @Override
    public int taille() {
        return this.fin.taille() + this.liste.taille();
    }


    @Override
    public FileImmutable<E> creer(E dernier) {
        return new FileImmutableParListe<E>(this.fin, Liste.cons(dernier, this.liste));
    }

    @Override
    public FileImmutable<E> ajout(E dernierDansFile) {
        return new FileImmutableParListe<E>(this.fin, Liste.cons(dernierDansFile, this.liste));
    }

    @Override
    public FileImmutable<E> retrait() {

        if(!this.fin.casVide()){

            return new FileImmutableParListe<E>(this.fin.reste(), this.liste);

        }

        else {

            if(!this.liste.casVide()){

                return new FileImmutableParListe<E>(this.liste.miroir().reste(), Liste.vide());

            }

            return new FileImmutableParListe<E>(Liste.vide(), Liste.vide());
        }
    }

    @Override
    public FileImmutable<E> ajout(File<E> secondeFile) {

        Liste<E> liste = Liste.vide();

        while(!secondeFile.estVide()){

            liste = Liste.cons(secondeFile.premier(), liste);
            secondeFile = secondeFile.retrait();

        }

        return new FileImmutableParListe<E>(this.fin, liste);
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return !(fin.casVide() || liste.casVide());
            }

            @Override
            public E next() {

                E t;

                if (!fin.casVide()) {

                    t = fin.tete();
                } else {

                    fin = liste.miroir();
                    t = fin.tete();
                }

                retrait();
                return t ;

            }


        };
    }

    public Liste<E> getListe(){
        return this.liste;
    }

    public Liste<E> getFin(){
        return this.fin;
    }
}
