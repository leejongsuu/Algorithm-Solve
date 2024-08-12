class Solution {
    public long solution(long n) {
        long num = (long) Math.sqrt(n);
        if(num * num == n) {
            return (long) Math.pow(num + 1, 2);
        } else {
            return -1;
        }
    }
}