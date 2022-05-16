package b10_dsa_stack_queue.bai_tap.b02_count_map;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {
    LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList();
    }

    public void push(T element){
        stack.addFirst(element);
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
