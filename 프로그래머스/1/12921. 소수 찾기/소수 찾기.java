import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        boolean[] prime = new boolean[n+1];
        
        for(int i = 3; i <=n; i+=2) {
            if(!prime[i]) {
                answer++;
                for(int j = 2; i * j <=n; j++) {
                    prime[i * j] = true;
                }
            }
        }
        
        return answer;
    }
    
    
}