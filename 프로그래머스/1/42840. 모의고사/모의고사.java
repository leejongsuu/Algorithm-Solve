import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] person1 = new int[]{1,2,3,4,5};
        int[] person2 = new int[]{2,1,2,3,2,4,2,5};
        int[] person3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(person1[i % person1.length] == answers[i]) count[0]++;
            if(person2[i % person2.length] == answers[i]) count[1]++;
            if(person3[i % person3.length] == answers[i]) count[2]++;
        }
        
        int max = Arrays.stream(count).max().getAsInt();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(count[i] == max) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}