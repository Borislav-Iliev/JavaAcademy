package CustomLinkedList;

public class CustomLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public void add(E element) {
        Node<E> newNode = new Node<E>(element);

        if (this.head == null) {
            this.head = this.tail = newNode;
            this.head.setPrev(null);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
            this.tail.setNext(null);
        }
        this.size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds");
        }

        if (index == 0) {
            addFirst(element);
        }

        if (index == this.size) {
            addLast(element);
        }

        Node<E> newNode = new Node<E>(element);
        Node<E> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        newNode.setPrev(currentNode);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        this.size++;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<E>(element);

        if (this.head == null) {
            this.tail = newNode;
        } else {
            this.head.setPrev(newNode);
        }

        newNode.setNext(this.head);
        this.head = newNode;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<E>(element);
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);
        this.tail = newNode;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds!");
        }

        if (index == 0) {
            removeFirst();
        }

        if (index == this.size) {
            removeLast();
        }

        Node<E> currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
    }

    public void removeFirst() {
        Node<E> currentElement = this.head;
        this.head = currentElement.getNext();
        this.head.setPrev(null);
    }

    public void removeLast() {
        Node<E> previous = this.tail.getPrev();
        previous.setNext(null);
        this.tail = previous;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds!");
        }

        Node<E> currentElement = this.head;

        for (int i = 0; i < index; i++) {
            currentElement = currentElement.getNext();
        }

        return currentElement.getValue();
    }

    public boolean addAll(CustomLinkedList<E> customLinkedList) {
        if (customLinkedList == null) {
            throw new NullPointerException("Custom Linked List cannot be null!");
        }

        if (customLinkedList.size == 0) {
            return false;
        }

        for (int i = 0; i < customLinkedList.size; i++) {
            Node<E> currentElement = customLinkedList.head;

            this.add(currentElement.getValue());

            currentElement = currentElement.getNext();
        }

        return true;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int indexOf(E element) {
        Node<E> currentElement = this.head;

        for (int i = 0; i < this.size; i++) {

            if (currentElement.getValue() == element) {
                return i;
            }

            currentElement = currentElement.getNext();
        }

        return -1;
    }

    public int lastIndexOf(E element) {
        int index = -1;
        Node<E> currentElement = this.head;

        for (int i = 0; i < this.size; i++) {

            if (currentElement.getValue() == element) {
                index = i;
            }

            currentElement = currentElement.getNext();
        }

        return index;
    }

    public boolean contains(E element) {
        Node<E> currentElement = this.head;

        while (currentElement != null) {
            if (currentElement.getValue() == element) {
                return true;
            }

            currentElement = currentElement.getNext();
        }

        return false;
    }

    public boolean containsAll(CustomLinkedList<E> customLinkedList) {
        if (customLinkedList == null) {
            throw new NullPointerException("Custom Linked List cannot be null");
        }

        if (customLinkedList.size == 0) {
            return false;
        }

        for (int i = 0; i < customLinkedList.size; i++) {
            Node<E> currentElement = customLinkedList.head;

            if (!this.contains(currentElement.getValue())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<E> currentElement = this.head;
        while (currentElement != null) {
            sb.append(currentElement.getValue()).append(", ");
            currentElement = currentElement.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}
