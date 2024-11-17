class Solution {
    public int solution(int n, int k) {
        String str = toChange(n, k);
        String[] strArr = str.split("0+");
        
        int result = 0;
        for(String temp : strArr) {
            if(isPrime(Long.parseLong(temp))) {
                result++;
            }
        }
        
        return result;
    }
    
    private String toChange(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > k) {
            sb.insert(0, n % k);
            n /= k;
        }
        sb.insert(0, n % k);
        
        return sb.toString();
    }
    
    private boolean isPrime(long num) {
        if(num == 1) return false;
        for(int i = 3; i <= Math.sqrt(num); i+=2) {
            if(num % i == 0) return false;
        }
        return true;
    }
}