import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int answer = 0;
        
        HashSet<Integer> hash = new HashSet<>();
        
        int len = nums.length;
        for(int i=0; i<len; i++){
            hash.add(nums[i]);
        }
        
        answer = Math.min(len/2,hash.size());
        
        return answer;
    }
}