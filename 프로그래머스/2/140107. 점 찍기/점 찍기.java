class Solution {
    public long solution(int k, int d) {
        long result = 0;
        long D = d;
        long K = k;
        long maxX = D / K;
        long d2 = D * D;
        
        for(long x = 0; x <= maxX; x++) {
            long xk = x * K;
            long remain = d2 - xk * xk;
            
            if(remain < 0) break;
            
            long maxY = (long) (Math.sqrt(remain) / K);
            result += maxY + 1;
        }
        
        return result;
    }
}