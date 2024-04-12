import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[][] patterns = new int[][]{
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] hit = new int[3];
        
        for(int i=0; i < hit.length; i++) {
            for(int j=0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }
        
        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<3; i++) {
            if(hit[i] == max) list.add(i+1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}