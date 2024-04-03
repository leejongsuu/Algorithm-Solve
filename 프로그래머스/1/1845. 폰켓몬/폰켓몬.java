import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(map.get(nums[i]),0)+1);
        }
        
        int len = nums.length / 2;
        int size = map.size();
        
        if(len < size){
            answer = len;
        } else {
            answer = size;
        }
        return answer;
    }
}