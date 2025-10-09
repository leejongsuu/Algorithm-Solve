import java.util.*;

class Solution {

    public int[] solution(int[] answers) {
        
        final int[] one = {1, 2, 3, 4, 5};
        final int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] counts = new int[3];
        
        int index = 0;
        for(int answer : answers) {
            if(one[index % one.length] == answer) counts[0]++;
            if(two[index % two.length] == answer) counts[1]++;
            if(three[index % three.length] == answer) counts[2]++;
            index++;
        }
        
        int max = Math.max(counts[0], Math.max(counts[1], counts[2]));
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(counts[i] == max) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}