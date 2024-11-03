package evaluaciones.retos.pinedaOscar_reto02;

public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        } else {
            n.setNext(this.first);
            this.first = n;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
            }
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            Node temp = this.first;
            this.first = this.first.getNext();
            temp.setNext(null);
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null) return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public FoundNodeList find(String value) {
        FoundNodeList foundList = new FoundNodeList();
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundList.insertEnd(iterator.getValue());
            }
            iterator = iterator.getNext();
        }
        return foundList;
    }

    public void deleteAll() {
        while (this.first != null) {
            Node temp = this.first;
            this.first = this.first.getNext();
            temp.setNext(null);
        }
    }
}