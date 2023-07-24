package CustomLinkedList;

public class Node<E> {
    private E value;
    private Node<E> next;
    private Node<E> prev;

    public Node() {
    }

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public Node<E> setValue(E value) {
        this.value = value;
        return this;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> setNext(Node<E> next) {
        this.next = next;
        return this;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> setPrev(Node<E> prev) {
        this.prev = prev;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value;
    }
}
