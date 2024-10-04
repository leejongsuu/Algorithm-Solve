class Solution {
    public int solution(int[] arr) {
    
        int inc = 1;
        for(int num : arr) {
            int gcd = getGcd(inc, num);
            inc = (num * inc) / gcd;
        }
        
        return inc;
    }
    
    private int getGcd(int a, int b) {
        
        int temp = 0;
        
        while(b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}