package ProjetoArvore.model;

public abstract class ObjArvore<T> implements Comparable {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(Object outro);
    public abstract String toString();


}
