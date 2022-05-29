package myCollections;

public class Wrapper<T> {
    T item;
    Wrapper prev;
    Wrapper next;

    public Wrapper(T item) {
        this.item = item;
        this.prev = null;
        this.next = null;
    }
}
