package ocjp_cerification_concepts.generics;

public class Generics3InterfaceImpl<K, V> implements Generics3Interface<K, V> {
    private K key;
    private V value;

    Generics3InterfaceImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public <T> void print(T item) {
        System.out.println(item);
    }
}
