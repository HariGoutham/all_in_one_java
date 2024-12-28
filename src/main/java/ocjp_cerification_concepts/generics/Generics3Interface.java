package ocjp_cerification_concepts.generics;

public interface Generics3Interface<K, V>{
    K getKey();
    V getValue();

    <T> void print(T item);

}
