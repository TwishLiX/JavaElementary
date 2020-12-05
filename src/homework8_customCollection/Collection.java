package homework8_customCollection;

public interface Collection {
    boolean add(Object o);

    boolean add(int index, Object o);

    boolean remove(Object o);

    boolean remove(int index);

    String get(int index);

    boolean contains(Object o);

    boolean equals (StringCollection collection);

    boolean clear();

    int size();
}
