import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++) {
            PQ.offer(score[i]);
            if(PQ.size() > k) PQ.poll();
            answer[i] = PQ.peek();
        }
        
        return answer;
    }
}