import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int result = 0;
        result++;
        
        int end = targets[0][1];
        for(int[] target : targets) {
            if(target[0] >= end) {
                result++;
                end = target[1];
            }
        }
        
        return result;
    }
}