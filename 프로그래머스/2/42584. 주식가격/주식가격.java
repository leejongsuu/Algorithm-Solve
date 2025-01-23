import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        
        int N = prices.length;
        int[] result = new int[N];
        
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                result[i]++;
                if(prices[j] < prices[i]) {
                    break;
                }
            }
        }
        
        return result;
    }
}