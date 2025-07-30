class Solution {
    public long solution(int w, int h) {
        
        int g = getGcd(w, h);
        
        
        return (long) w * h - (w + h - g);
    }
    
    private int getGcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}