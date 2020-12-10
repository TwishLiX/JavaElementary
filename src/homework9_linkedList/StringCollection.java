package homework9_linkedList;

public class StringCollection implements CustomCollection {
    private Node head;
    private Node tail;
    private int count;

    @Override
    public boolean add(String value) {
        Node tempNode = new Node(value);
        if (head == null) {
            head = tempNode;
        } else {
            tail.setNext(tempNode);
            tempNode.setPrev(tail);
        }
        tail = tempNode;
        count++;
        return true;
    }

    @Override
    public boolean addAll(String[] stringArray) {
        if (stringArray.length != 0) {
            for (int i = 0; i < stringArray.length; i++) {
                add(stringArray[i]);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(StringCollection collection) {
        if (collection.size() != 0) {
            for (int i = 0; i < collection.size(); i++) {
                add(collection.get(i));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return delete(current);
        }
    }

    @Override
    public boolean remove(String value) {
        if (size() != 0) {
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(value)) {
                    remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (index > count && index < 0) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getItem();
        }
    }

    @Override
    public boolean contains(String value) {
        if (size() != 0) {
            Node current = head;
            for (int i = 0; i < size(); i++) {
                if (current.getItem().equals(value)) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (size() != 0) {
            for (Node node = head; node != null; ) {
                Node next = node.getNext();
                node.setNext(null);
                node.setPrev(null);
                node = next;
            }
            head = tail = null;
            count = 0;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean trim() {
        if (size() != 0) {
            int count = 0;
            Node current = head;
            while (current != null) {
                if (current.getItem() == null) {
                    Node next = current.getNext();
                    delete(current);
                    count++;
                    current = next;
                    continue;
                }
                current = current.getNext();
            }
            return count > 0;
        }
        return false;
    }

    @Override
    public boolean compare(StringCollection collection) {
        if (this.size() != collection.size() || this.size() == 0 || collection.size() == 0) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(collection.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean delete(Node current) {
        if (current == head) {
            head = current.getNext();
        } else {
            current.getPrev().setNext(current.getNext());
        }
        if (current == tail) {
            tail = current.getPrev();
        } else {
            current.getNext().setPrev(current.getPrev());
        }
        count--;
        return true;
    }
}
