package Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        Queue<String> q = new ArrayDeque<>();
        int n = 10;
        q.add("5");
        q.add("6");
        for(int i = 0; i<n ; i++){
            String x = q.poll();
            q.add(x+"5");
            q.add(x+"6");
            System.out.println(x);
        }
    }
}
