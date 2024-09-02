class Solution {
    public int solution(int a, int b, int n) {
        
        int result = 0;
        
        while(n >= a) {
            int quotient = n / a;
            result += b * quotient;
            n = (n % a) + (b * quotient);
        }
        
        return result;
    }
}