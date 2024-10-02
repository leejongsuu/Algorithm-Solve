class Solution {
    public int solution(int n) {
        return getOdd(n);
    }
    
    private int getOdd(int n) {
        int count = 0;
        
        for(int i = 1; i <= n; i+=2) {
            if(n % i == 0) {
                count++;
            }
        }
        
        return count;
    }
}