class Solution {
    public int solution(int[] arr) {
        
        int inc = arr[0];
        
        for(int i= 1; i < arr.length; i++) {
            int gcd = getGcd(inc, arr[i]);
            inc = (inc * arr[i]) / gcd;
        }
        
        return inc;
    }
    
    private int getGcd(int a, int b) {
        int temp = b;
        while(b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}