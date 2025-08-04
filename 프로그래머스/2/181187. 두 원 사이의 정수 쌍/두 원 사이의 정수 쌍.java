class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long R1 = 1L * r1 * r1;
        long R2 = 1L * r2 * r2;
        
        for(int x = 1; x <= r2; x++) {
            long X = 1L * x * x;
            
            int maxY = (int) Math.floor(Math.sqrt(R2 - X));
            int minY = (int) Math.ceil(Math.sqrt(R1 - X));
            
            answer += 4 * (maxY - minY + 1);
        }
        
        return answer;
    }
}