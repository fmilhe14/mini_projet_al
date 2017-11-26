package tp.v5;

import java.util.Iterator;

/**
 * Interface représentant les propriétés d'un objet itérable pouvant être représenté.
 *
 * @param <E> le type des éléments itérés.
 */
public interface RepresentableParIteration<E> extends Representable, Iterable<E> {

    @Override
    default String representation() {
        Iterator<E> iter = this.iterator();
        if (!iter.hasNext()) {
            return "[]";
        }
        StringBuilder r = new StringBuilder();
        r.append("[");
        r.append(iter.next().toString());
        while (iter.hasNext()) {
            r.append(", ");
            r.append(iter.next().toString());
        }
        r.append("]");
        return r.toString();
    }
}
