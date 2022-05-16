package b10_dsa_stack_queue.thuc_hanh.linked_list;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList();
    }

    public void push(T elemnent){
        stack.addFirst(elemnent);
    }

    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty(){
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
