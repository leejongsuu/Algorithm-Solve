import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] result = new int[(int) (right - left) + 1];
        
        for(int i = 0; left <= right; i++, left++) {
            result[i] = (int) Math.max(left / n, left % n) + 1;
        }
        
        return result;
    }
}