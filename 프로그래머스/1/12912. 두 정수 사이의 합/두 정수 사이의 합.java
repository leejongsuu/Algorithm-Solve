class Solution {
    public long solution(int a, int b) {
        
        long sum = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for(int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }
}