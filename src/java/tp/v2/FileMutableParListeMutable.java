package tp.v2;

import java.util.Iterator;

/**
 * Created by francoismilhem on 06/11/2017.
 */
public class FileMutableParListeMutable<E> implements FileMutable<E> {

    private ListeMutable<E> liste;
    private ListeMutable<E> fin;

    public FileMutableParListeMutable(ListeMutable liste, ListeMutable fin) {

        this.liste = liste;
        this.fin = fin;

        if(this.fin.casVide() && !this.liste.casVide()){
            this.fin = this.liste.miroir();
            this.liste = ListeMutable.vide();
        }

    }

    public FileMutableParListeMutable() {

        this.liste = ListeMutable.vide();
        this.fin = ListeMutable.vide();
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
    public int taille() {
        return this.fin.taille() + this.liste.taille();
    }

    @Override
    public void ajouter(E element) {

        if(this.liste.casCons()) {

            this.liste.changerTete(element);
        }

        else {
            this.liste = ListeMutable.cons(element, ListeMutable.vide());
        }
    }

    @Override
    public void retirer() {

        if(this.fin.casVide()) {

            if(this.liste.casVide()){

                throw new UnsupportedOperationException("File has no elements");
            }

            else {

                this.fin = this.liste.miroir().reste();
                this.liste = ListeMutable.vide();
            }

        }

        else {

            this.fin = this.fin.reste();

            if(this.fin.estVide()){

                this.fin = ListeMutable.vide();
            }
        }

    }

    @Override
    public FileMutable<E> creer() {
        return new FileMutableParListeMutable<E>();
    }

    @Override
    public FileMutable<E> creerCopie() {
        return new FileMutableParListeMutable<E>(this.liste, this.fin);
    }

    @Override
    public void ajouter(File<E> secondeFile) {

        while(!secondeFile.estVide()){

            this.ajouter(secondeFile.premier());
            secondeFile = secondeFile.retrait();

        }
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

                if(!fin.casVide()) {

                     t = fin.tete();
                }

                else {

                    fin = liste.miroir();
                    t = fin.tete();

                }

                    retirer();
                    return t;
            }
        };
    }

    public ListeMutable<E> getListe(){
        return this.liste;
    }

    public ListeMutable<E> getFin(){
        return this.fin;
    }
}
