package b09_dsa_list.bai_tap.array_list;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public void add(int index, E element){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't correct");
        }

        if (size == elements.length){
            ensureCapacity(elements.length *2);
        }

        for(int i = index; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't correct");
        }

        for (int i = index; i < elements.length - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[index] = null;
        size--;
        return null;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone(){
        MyList<E> newList = new MyList<>(elements.length);
        for(int i = 0; i < elements.length; i++){
            newList.elements[i] = elements[i];
        }
        newList.size = size;
        return newList;
    }

    public boolean contains(E element){
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;

    }

    public int indexOf(E element){
        for(int i = 0; i < size; i++){
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element){
        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        elements[size++] = element;
        return true;
    }

    public void ensureCapacity(int minCapacity){
        Object[] newElements = new Object[minCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    public E get(int index){
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't correct");
        }
        return (E) elements[index];
    }

    public void clear(){
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }
}
