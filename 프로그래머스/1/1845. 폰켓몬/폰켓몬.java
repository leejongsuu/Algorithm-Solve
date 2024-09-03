import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Boolean> numberMap = new HashMap<>();
        for(int num : nums) {
            numberMap.putIfAbsent(num, true);
        }
        
        return Math.min(nums.length / 2, numberMap.size());
    }
}