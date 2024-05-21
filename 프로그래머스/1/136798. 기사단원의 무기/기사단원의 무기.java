class Solution {
    public int solution(int number, int limit, int power) {
        int result = 0;
        
        for(int i = 1; i<= number; i++) {
            result += getGcd(i, limit, power);   
        }
        return result;
    }
    
    private int getGcd(int n, int limit, int power) {
        int cnt = 0;
        int len = (int) Math.sqrt(n);
        for(int i = 1; i <= len; i++) {
            if(n % i == 0) {
                cnt++;
            }
        }
        
        cnt *= 2;
        if(n == (int) Math.pow(len, 2)) cnt --;
        
        return cnt > limit ? power : cnt;
    }
}