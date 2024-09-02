import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int len = score.length;
        int[] result = new int[len];
        
        PriorityQueue<Integer> hallQueue = new PriorityQueue<>();
        
        for(int i = 0; i < len; i++ ) {
            if(i < k) {
                hallQueue.offer(score[i]);
            } else {
                int min = hallQueue.poll();
                if(score[i] > min) {
                    hallQueue.offer(score[i]);
                } else {
                    hallQueue.offer(min);
                }
            }
            result[i] = hallQueue.peek();
        }
        
        return result;
    }
}