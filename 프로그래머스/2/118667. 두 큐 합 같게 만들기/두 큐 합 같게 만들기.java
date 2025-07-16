import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int len1 = queue1.length;
        int len2 = queue2.length;
        int len = len1 + len2;
        
        long sum1 = 0;
        long sum2 = 0;
        
        int[] queue = new int[len];
        for(int i = 0; i < len1; i++) {
            queue[i] = queue1[i];
            sum1 += queue1[i];
        }
        for(int i = 0; i < len2; i++) {
            queue[i + len1] = queue2[i];
            sum2 += queue2[i];
        }
        
        int count = 0;
        long sum = sum2;
        long target = (sum1 + sum2) / 2;
        
        for(int lt = 0, rt = len1; lt < len && rt < len; count++) {
            if(sum == target) break;
            
            if(sum < target) {
                sum += queue[lt++];
            } else {
                sum -= queue[rt++];
            }
        }
        
        return sum == target ? count : -1;
    }
}