package homework12_collectionTests;

public class StringCollection implements Collection {
    private String[] collection;
    private int count = 0;

    public StringCollection() {
        collection = new String[10];
    }

    public StringCollection(int size) {
        collection = new String[size];
    }

    @Override
    public boolean add(Object o) {
        if (count > collection.length - 1) {
            resize();
        }
        collection[count++] = (String) o;
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } else {
            if (index == count && count <= collection.length - 1) {
                collection[count++] = (String) o;
            } else if (index == count && count > collection.length - 1) {
                resize();
                collection[count++] = (String) o;
            } else {
                String[] tempArray = new String[collection.length + 1];
                count++;
                for (int i = 0; i < index; i++) {
                    tempArray[i] = collection[i];
                }
                tempArray[index] = (String) o;
                for (int i = index + 1, j = index; i < size(); i++, j++) {
                    tempArray[i] = collection[j];
                }
                collection = new String[tempArray.length];
                for (int i = 0; i < collection.length; i++) {
                    collection[i] = tempArray[i];
                }
            }
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int counter = 0;
        for (int i = 0; i < size(); i++) {
            if (collection[i].equals(o)) {
                remove(i);
                counter++;
            }
        }
        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int index) {
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
            return true;
        }
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index <= count) {
            return collection[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (collection[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(StringCollection value) {
        if (this.size() != value.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (this.collection[i] != value.collection[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < size(); i++) {
            collection[i] = null;
        }
        count = 0;
        return true;
    }

    @Override
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
