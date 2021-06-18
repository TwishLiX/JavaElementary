package homework9_linkedList;

public interface CustomCollection {
    boolean add(String value);

    boolean addAll(String[] stringArray);

    boolean addAll(StringCollection collection);

    boolean remove(int index);

    boolean remove(String value);

    String get(int index);

    boolean contains(String value);

    boolean clear();

    int size();

    boolean trim();

    boolean compare(StringCollection collection);
}
