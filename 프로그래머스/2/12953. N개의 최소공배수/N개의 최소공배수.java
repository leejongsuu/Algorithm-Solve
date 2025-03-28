class Solution {
    public int solution(int[] arr) {
        
        int inc = 1;
        for(int num : arr) {
            inc = inc * num / getGcd(inc, num);
        }
        
        return inc;
    }
    
    public int getGcd(int a, int b) {
        int temp = 0;
        while(b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}