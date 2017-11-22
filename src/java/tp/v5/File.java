package tp.v5;

/**
 * Created by francoismilhem on 22/11/2017.
 */
public interface File<K extends File<K, E>, E> extends Iterable<E>, Mesurable  {


    E premier();
    K suivants();

    default boolean estVide(){

        return this.taille() == 0 ;
    }

    K creer();

    @SuppressWarnings("unchecked")
    default K sujet(){
        return (K)this;
    }

    K ajout(E dernierDansFile);

    K retrait();

    //Méthode recupérée dans la classe v3.File
    default K ajout(K secondeFile){

        K r = this.sujet();
        for(E e : secondeFile){
            r = r.ajout(e);
        }
        return r;
    }

}
