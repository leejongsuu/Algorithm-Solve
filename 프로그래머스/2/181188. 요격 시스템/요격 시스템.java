import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int answer = 0;
        answer++;
        
        int end = targets[0][1];
        
        for(int[] tar : targets) {
            if(tar[0] >= end) {
                answer++;
                end = tar[1];
            }
        }
        
        return answer;
    }
}