class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long R1 = 1L * r1 * r1;
        long R2 = 1L * r2 * r2;
        
        for(long x = 1; x <= r2; x++) {
            long X2 = x * x;
            long maxY = (long) Math.floor(Math.sqrt(R2 - X2));
            long minY = (long) Math.ceil(Math.sqrt(R1 - X2));
            answer += (maxY - minY + 1) * 4;
        }
        
        return answer;
    }
}