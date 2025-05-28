class Solution {
    public String solution(int n) {
        int[] numbers = {1, 2, 4};
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            n -= 1;
            sb.insert(0, numbers[n % 3]);
            n /= 3;
        }
        
        return sb.toString();
    }
}