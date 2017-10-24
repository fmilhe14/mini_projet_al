/**
 * Created by francoismilhem on 24/10/2017.
 */
public interface File<T> {

    //Méthode pour ajouter un élément à la file
    void ajouter(T o);

    //Méthode pour consulter l'élément en tête de la file
    T tete() throws IndexOutOfBoundsException;

    //Méthode pour retirer l'élément en tête de la file
    T retirer();

    //Méthode qui retourne true si la file est vide
    default boolean estVide(){ return true;}

}
