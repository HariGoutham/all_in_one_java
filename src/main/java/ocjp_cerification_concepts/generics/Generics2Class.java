package ocjp_cerification_concepts.generics;

class Generics2Class<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
