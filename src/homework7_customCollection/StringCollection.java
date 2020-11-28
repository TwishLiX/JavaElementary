package homework7_customCollection;

public class StringCollection {
    private String[] collection;
    private int cell = 0;

    public StringCollection() {
        collection = new String[10];
    }

    public StringCollection(int size) {
        collection = new String[size];
    }

    public void add(String value) {
        int size = collection.length;
        if (cell > collection.length - 1) {
            size += collection.length / 1.5;
            String[] tempArray = new String[collection.length];
            System.arraycopy(collection, 0, tempArray, 0, collection.length);
            collection = new String[size];
            System.arraycopy(tempArray, 0, collection, 0, tempArray.length);
        }
        collection[cell] = value;
        cell++;
    }

    public void add(int index, String value) {
        collection[index] = value;
    }

    public void delete(String value) {
        for (int i = 0; i < size(); i++) {
            if (collection[i].equals(value)) {
                delete(i);
            }
        }
    }

    public void delete(int index) {
        String[] tempArray = new String[collection.length - 1];
        for (int i = 0; i < index; i++) {
            tempArray[i] = collection[i];
        }
        for (int i = index + 1, j = index; i < size(); i++, j++) {
            tempArray[j] = collection[i];
        }
        collection = new String[tempArray.length];
        System.arraycopy(tempArray, 0, collection, 0, collection.length);
        cell--;
    }

    public String get(int index) {
        if (collection[index] != null) {
            return "String{" + collection[index] + "}";
        }
        return null;
    }

    public int size() {
        int counter = 0;
        for (String s : collection) {
            if (s != null) {
                counter++;
            }
        }
        return counter;
    }
}
