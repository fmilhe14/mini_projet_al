import java.util.LinkedList;
import java.util.List;

/**
 * Created by francoismilhem on 24/10/2017.
 * Première implémentation mutable de l'interface File, implémentée avec une LinkedList
 */
public class FileMutable<T> implements File<T>, FabriqueFileMutable {

    private List<T> list;


    public FileMutable(LinkedList list) {

        this.list = list;
    }

    public FileMutable() {

        this(new LinkedList<T>());
    }

    @Override
    public void ajouter(T o) {

        this.list.add(o);
    }

    @Override
    public T tete() throws IndexOutOfBoundsException {

        if (!this.estVide()) {
            return this.list.get(0);
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public T retirer() {

        if (!this.estVide()) {
            return this.list.remove(0);
        }

        throw new IndexOutOfBoundsException();

    }

    @Override
    public int size() {

        return this.list.size();
    }

    @Override
    public boolean estVide() {

        return this.list.isEmpty();
    }
}

