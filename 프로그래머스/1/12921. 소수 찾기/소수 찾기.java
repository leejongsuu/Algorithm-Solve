class Solution {
    public int solution(int n) {
        
        int result = 0;
        
        boolean[] isNotPrime = new boolean[n+1];
        for(int i = 2; i <= n; i++) {
            if(!isNotPrime[i]) {
                result++;
                for(int j = 2; i * j <= n; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }
        
        return result;
        
    }
}