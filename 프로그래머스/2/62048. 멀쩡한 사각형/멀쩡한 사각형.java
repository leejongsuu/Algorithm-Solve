class Solution {
    public long solution(long w, long h) {
        long g = gcd(w, h);
        long unusable = w + h - g;
        return w * h - unusable;
    }
    
    long gcd(long a, long b) {
        while(b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}