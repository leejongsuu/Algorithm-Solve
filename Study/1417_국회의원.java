import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        int[] candidates = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            candidates[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int candidate : candidates) {
            priorityQueue.offer(candidate);
        }

        int count = 0;
        while (!priorityQueue.isEmpty()) {
            int temp = priorityQueue.poll();
            if (dasom > temp) {
                break;
            }
            priorityQueue.offer(temp - 1);
            dasom++;
            count++;
        }

        System.out.println(count);
    }
}
