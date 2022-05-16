package b04_oop_java.baitap.b02_stop_watch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] numbers = new int[10000000];
        for (int i = 0; i<numbers.length; i++){
            numbers[i] = (int) (Math.random()*10000000);
        }
        stopWatch.start();
        Arrays.sort(numbers);
        stopWatch.stop();
        System.out.println("milisecond: "+ stopWatch.getElapsedTime());
    }
}
