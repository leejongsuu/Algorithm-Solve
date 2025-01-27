import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        int result = 0;

//        int stock = 4;
//        int[] dates = {4, 10, 15};
//        int[] supplies = {20, 5, 10};
//        int k = 30;

//        int stock = 0;
//        int[] dates = {0, 10, 15};
//        int[] supplies = {20, 10, 15};
//        int k = 35;

        int stock = 0;
        int[] dates = {0, 20, 25};
        int[] supplies = {20, 10, 15};
        int k = 35;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while (stock < k) { // stock이 k보다 크게 되면 멈춤.
            for (; i < dates.length && dates[i] <= stock; i++) {
                priorityQueue.offer(supplies[i]);
            }
            stock += priorityQueue.poll();
            result++;
        }

        System.out.println(result);
    }
}
