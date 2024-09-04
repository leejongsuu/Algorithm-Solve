class Solution {
    public int solution(int n) {
        
        int count = 0;
        
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(int num) {
        
        if(num == 2) {
            return true;
        }
        else if(num % 2 == 0) {
            return false;
        } else {
            int sqrt = (int) Math.sqrt(num);
            for(int i = 3; i <= sqrt; i+=2) {
                if(num % i ==0) return false;
            }
        }
        
        return true;
    }
}