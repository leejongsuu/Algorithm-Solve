class Solution {
    public long solution(int a, int b) {
        return calculate(Math.max(a,b)) - calculate(Math.min(a,b) - 1);
    }
    
    public long calculate(long num) {
        return (num * (num + 1)) / 2;
    }
}