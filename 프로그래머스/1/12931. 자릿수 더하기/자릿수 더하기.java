public class Solution {
    public int solution(int n) {
        int result = 0;
        
        int i = 10;
        while(n > 0) {
            result += n % i;
            n /= 10;
        }
        
        return result;
    }
}