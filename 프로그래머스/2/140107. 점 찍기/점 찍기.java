class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long D2 = 1L * d * d;
        int maxX = d / k;
        
        for(int x = 0; x <= maxX; x++) {
            long XK2 = 1L * x * x * k * k;
            answer += (int) Math.sqrt(D2 - XK2) / k + 1;
        }
        
        return answer;
    }
}