class Solution {
    public int[] solution(long begin, long end) {

        int first = (int) begin;
        int last  = (int) end;
        int len   = last - first + 1;
        
        int[] answer = new int[len];
        
        for (int i = first; i <= last; i++) {
            answer[i - first] = getDivide(i);
        }
        return answer;
    }
    
    private int getDivide(int num) {
        if (num == 1) {
            return 0;
        }
        int best = 1;  // 1은 항상 후보(약수)이며, 블록 1도 깔릴 수 있음
        
        int limit = (int) Math.sqrt(num);
        for (int d = 2; d <= limit; d++) {
            if (num % d == 0) {
                int partner = num / d;

                if (partner <= 10_000_000) {
                    best = Math.max(best, partner);
                }
                
                best = Math.max(best, d);
            }
        }
        return best;
    }
}
