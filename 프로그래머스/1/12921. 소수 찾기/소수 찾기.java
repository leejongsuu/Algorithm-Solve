class Solution {
    boolean[] isNotPrime;
    
    public int solution(int n) {
        
        int result = 0;
        boolean[] isNotPrimes = getIsNotPrimes(n);
        for(int i = 2; i <= n; i++) {
            if(!isNotPrimes[i]) result++;
        }
        
        return result;
    }
    
    public boolean[] getIsNotPrimes(int num) {
        boolean[] isNotPrimes = new boolean[num + 1];
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(!isNotPrimes[i]) {
                for(int j = 2; i * j <= num; j++) {
                    isNotPrimes[i * j] = true;
                }
            }
        }
        return isNotPrimes;
    }
}