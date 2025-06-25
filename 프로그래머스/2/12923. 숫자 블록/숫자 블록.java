class Solution {
    public int[] solution(long begin, long end) {
    
        int first = (int) begin;
        int last = (int) end;
        
        int size = (last - first + 1);
        int[] answer = new int[size];
        
        for(int i = first; i <= last; i++) {
            answer[i - first] = getDivide(i);
        }
        
        return answer;
    }
    
    private int getDivide(int num) {
        if(num == 1) {
            return 0;
        }
        
        int best = 1;
        int size = (int) Math.sqrt(num);
        for(int div = 2; div <= size; div++) {
            if(num % div == 0) {
                int partner = num / div;
                if(partner <= 10_000_000) {
                    best = Math.max(best, partner);
                }
                
                best = Math.max(best, div);
            }
        }
        
        return best;
    }
}