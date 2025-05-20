class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int len = queue1.length;
        int[] queue = new int[2 * len];
        
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            queue[i] = queue1[i];
            queue[i + len] = queue2[i];
        }
        
        long target = (sum1 + sum2) / 2;
        long cur = sum1;
        
        int lt = 0, rt = len;
        int level = 0;
        while(lt < rt && rt < 2 * len && lt < 2 * len) {
            if(cur == target) return level;
            
            if(cur < target) {
                cur += queue[rt++];
            } else {
                cur -= queue[lt++];
            }
            level++;
        }
        
        return -1;
    }
}