package tp.v2;

import java.util.Iterator;

/**
 * Created by francoismilhem on 06/11/2017.
 */
public class FileMutableParListeMutable<E> implements FileMutable<E> {

   private ListeMutable<E> liste;
   private ListeMutable<E> fin;

   public FileMutableParListeMutable(ListeMutable liste, ListeMutable fin){

       this.liste = liste;
       this.fin = fin;

   }

   public FileMutableParListeMutable(){

       this.liste = ListeMutable.vide();
       this.fin = ListeMutable.vide();
   }

    @Override
    public E premier() {
        return this.fin.tete();
    }

    @Override
    public int taille() {
        return this.fin.taille() + this.liste.taille();
    }

    @Override
    public void ajouter(E element) {
        this.liste.changerTete(element);
    }

    @Override
    public void retirer() {

    }

    @Override
    public FileMutable<E> creer() {
        return null;
    }

    @Override
    public FileMutable<E> creerCopie() {
        return null;
    }

    @Override
    public void ajouter(File<E> secondeFile) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
