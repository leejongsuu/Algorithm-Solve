import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
                
        for(int i = score.length; i>=0; i-=m) {    
            if(i - m < 0) break;
            int[] temp = Arrays.copyOfRange(score, i - m, i);
            answer += temp[0] * m;
        }
        
        return answer;
    }
}