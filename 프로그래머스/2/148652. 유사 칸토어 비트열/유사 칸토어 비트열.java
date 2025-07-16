class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i < r; i++) {
            answer += solution(i);
        }
        
        return answer;
    }
    
    int solution(long x) {
        while(x > 0) {
            if(x % 5 == 2) {
                return 0;  
            } 
            x /= 5;
        }
        return 1;
    }
}