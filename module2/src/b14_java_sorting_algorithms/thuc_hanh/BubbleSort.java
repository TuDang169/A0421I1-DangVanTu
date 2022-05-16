package b14_java_sorting_algorithms.thuc_hanh;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;

        for (int i = 1; i < list.length && needNextPass; i++) {
            needNextPass = false;

            for (int j = 0; j < list.length -i; j++) {
                if(list[j] > list[j+1]){
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}


