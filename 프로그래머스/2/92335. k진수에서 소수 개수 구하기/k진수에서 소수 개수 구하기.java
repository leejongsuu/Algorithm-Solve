class Solution {
    public int solution(int n, int k) {

        int result = 0;
        String str = toChange(n, k);
        
        String[] splited = str.split("0+");
        for(int i = 0; i < splited.length; i++) {
            if(isPrime(Long.parseLong(splited[i]))) {
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
        else {
            for(int i = 3; i <= Math.sqrt(num); i+=2) {
                if(num % i == 0) return false;
            }
        }
        return true;
    }
}