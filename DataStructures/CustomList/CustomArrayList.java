package CustomList;

import java.util.Arrays;

public class CustomArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;

    public CustomArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(E element) {
        if (this.elements.length == this.size) {
            increaseCapacity();
        }
        this.elements[this.size++] = element;
    }

    public boolean remove(E element) {
        for (int i = 0; i < this.size; i++) {
            E currentElement = this.elements[i];

            if (currentElement.equals(element)) {
                this.elements[i] = null;

                for (int j = i; j < this.elements.length - 1; j++) {
                    this.elements[j] = this.elements[j + 1];
                }

                this.size--;
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {

        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " is out of bounds for size: " + this.size);
        }

        E elementToFind = this.elements[index];

        for (int i = 0; i < this.size; i++) {
            E currentElement = this.elements[i];

            if (currentElement.equals(elementToFind)) {
                this.elements[i] = null;

                for (int j = i + 1; j < this.size - 1; j++) {
                    this.elements[j] = this.elements[j + 1];
                }

                this.size--;
                return elementToFind;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i <this.size ; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " is out of bounds for size: " + this.size);
        }
        return this.elements[index];
    }

    public boolean addAll(CustomArrayList<? extends E> customArrayList) {
        if (customArrayList == null) {
            throw new NullPointerException("Collection cannot be null!");
        }

        if (customArrayList.size() == 0) {
            return false;
        }

        for (int i = 0; i < customArrayList.size; i++) {
            E element = customArrayList.get(i);
            this.add(element);
        }

        return true;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            E currentElement = this.elements[i];

            if (currentElement == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            E currentElement = this.elements[i];

            if (currentElement == element) {
                index = i;
            }
        }
        return index;
    }

    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            E currentElement = this.elements[i];

            if (currentElement == element) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(CustomArrayList<E> customArrayList) {
        if (customArrayList == null) {
            throw new NullPointerException("Collection cannot be null!");
        }

        if (customArrayList.size() == 0) {
            return false;
        }

        for (int i = 0; i < customArrayList.size(); i++) {
            E element = customArrayList.get(i);

            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    private void increaseCapacity() {
        int newSize = DEFAULT_CAPACITY * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < this.size; i++) {
            E element = this.elements[i];

            if (i == this.size - 1) {
                sb.append(element);
                continue;
            }

            sb.append(element).append(", ");
        }

        sb.append("]");

        return sb.toString();
    }
}
