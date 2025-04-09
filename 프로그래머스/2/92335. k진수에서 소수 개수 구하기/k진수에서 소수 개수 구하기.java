class Solution {
    public int solution(int n, int k) {
        
        int result = 0;
        
        String scaled = toScale(n, k);
        for(String sNum : scaled.split("0{1,}")) {
            if(isPrime(Long.parseLong(sNum))) result++;
        }
        return result;
    }
    
    public String toScale(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        
        return sb.toString();
    }
    
    public boolean isPrime(long num) {
        if(num == 1) return false;
        for(long i = 2; i <= (long) Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}