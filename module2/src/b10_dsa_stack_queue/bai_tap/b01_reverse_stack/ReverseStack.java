package b10_dsa_stack_queue.bai_tap.b01_reverse_stack;

public class ReverseStack {
    public static void reverseStack(String[] array){
        Stack<String> stack= new Stack();
        for (int i = 0; i <array.length; i++) {
            stack.push(array[i]);
        }
        System.out.printf("Array after reverse: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
            System.out.printf(" %s",array[i]);
        }
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four", "five", "six"};
        reverseStack(array);
    }
}
