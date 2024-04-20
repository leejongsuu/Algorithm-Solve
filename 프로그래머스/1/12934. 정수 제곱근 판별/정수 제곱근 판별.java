class Solution {
    public long solution(long n) {
        long x = (long) Math.sqrt(n);
        return (long) Math.pow(x, 2) == n ? (long) Math.pow(x+1, 2) : -1; 
    }
}