package tp.v1;

import java.rmi.NoSuchObjectException;

/**
 * Created by francoismilhem on 24/10/2017.
 */
public interface File<T> {

    /**
     * ajoute un élément à la queue de file
      * @param o l'objet à ajouter
     */
    void ajouter(T o);


    /**
     * @return l'élément en tête de la file
     * @throws IndexOutOfBoundsException
     */
    T tete() throws IndexOutOfBoundsException;


    /**
     * @return l'élément en tête de la file, après l'avoir retiré
     */
    T retirer() throws IndexOutOfBoundsException;


    /**
     * @return le nombre d'objets contenus dans la file
     */
    int size();


    /**
     * @return true si la file est vide
     */
    default boolean estVide(){ return true;}
}