import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1]==arr[i]) continue;
            queue.offer(arr[i]);
        }
        
        answer = new int[queue.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i]=queue.poll();
        }

        return answer;
    }
}