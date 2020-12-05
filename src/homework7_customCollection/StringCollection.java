package homework7_customCollection;

public class StringCollection {
    private String[] collection;
    private int count = 0;

    public StringCollection() {
        collection = new String[10];
    }

    public StringCollection(int size) {
        collection = new String[size];
    }

    public void add(String value) {
        if (count > collection.length - 1) {
            resize();
        }
        collection[count++] = value;
    }

    public void add(int index, String value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } else if (index == count && count <= collection.length - 1) {
            collection[count++] = value;
        } else if (index == count && count > collection.length - 1) {
            resize();
            collection[count++] = value;
        } else {
            String[] tempArray = new String[collection.length + 1];
            count++;
            for (int i = 0; i < index; i++) {
                tempArray[i] = collection[i];
            }
            tempArray[index] = value;
            for (int i = index + 1, j = index; i < size(); i++, j++) {
                tempArray[i] = collection[j];
            }
            collection = new String[tempArray.length];
            for (int i = 0; i < collection.length; i++) {
                collection[i] = tempArray[i];
            }
        }
    }

    public void remove(String value) {
        for (int i = 0; i < size(); i++) {
            if (collection[i].equals(value)) {
                remove(i);
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } else {
            String[] tempArray = new String[collection.length - 1];
            for (int i = 0; i < index; i++) {
                tempArray[i] = collection[i];
            }
            for (int i = index + 1, j = index; i < size(); i++, j++) {
                tempArray[j] = collection[i];
            }
            collection = new String[tempArray.length];
            for (int i = 0; i < collection.length; i++) {
                collection[i] = tempArray[i];
            }
            count--;
        }
    }

    public String get(int index) {
        if (index >= 0 && index <= count) {
            return collection[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    public int size() {
        return count;
    }

    private void resize() {
        String[] tempArray = new String[collection.length];
        for (int i = 0; i < collection.length; i++) {
            tempArray[i] = collection[i];
        }
        collection = new String[(int) (tempArray.length + (tempArray.length / 1.5))];
        for (int i = 0; i < tempArray.length; i++) {
            collection[i] = tempArray[i];
        }
    }
}
