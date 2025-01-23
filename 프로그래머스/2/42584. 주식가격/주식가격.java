import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        
        int N = prices.length;
        int[] result = new int[N];
        
        Queue<Integer> queue = new LinkedList<>();
        for(int price : prices) {
            queue.offer(price);
        }
        
        for(int i = 0; i < N; i++) {
            int price = queue.poll();
            int time = 0;
            for(int j = i + 1; j < N; j++) {
                time++;
                if(price > prices[j]) {
                    break;
                }
            }
            result[i] = time;
        }
        
        return result;
    }
}