class Solution {
    public long solution(int w, int h) {
        int g = gcd(w, h);
        return (long) w * h - (w + h - g);
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}