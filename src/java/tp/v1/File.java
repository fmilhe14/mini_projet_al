package tp.v1;

/**
 * Created by francoismilhem on 24/10/2017.
 */
public interface File<T> {

    /**
     * ajoute un element a la queue de file
     * @param o l'objet a ajouter
     */
    void ajouter(T o);


    /**
     * @return l'element en tete de la file
     * @throws IndexOutOfBoundsException si la tete n'existe pas (ssi la liste est vide)
     */
    T tete() throws IndexOutOfBoundsException;


    /**
     * @return l'element en tete de la file, apres l'avoir retire
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