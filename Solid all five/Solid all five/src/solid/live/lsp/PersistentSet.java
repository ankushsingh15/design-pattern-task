package solid.live.lsp;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 12:56:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersistentSet<T> extends Set<T> {
    public void add(T element) {
        PersistentObject persistentObject = new PersistentObject(element);
        super.add((T) persistentObject);
    }

    public boolean isMember(T element) {
        for (Object o : innerSet) {
            if (o.equals(element))
                return true;
        }
        return false;
    }
}


public class PersistentSet<T> {
    private Set<PersistentObject<T>> innerSet = new Set<>();

    public void add(T element) {
        PersistentObject<T> persistentObject = new PersistentObject<>(element);
        innerSet.add(persistentObject);
    }

    public boolean isMember(T element) {
        for (PersistentObject<T> o : innerSet) {
            if (o.getData().equals(element))
                return true;
        }
        return false;
    }

    public int size() {
        return innerSet.size();
    }
}
