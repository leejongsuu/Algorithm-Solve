import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        
        int boat = 0;
        
        for(int lt = 0, rt = people.length - 1; lt <= rt; rt--) {
            if(people[lt] + people[rt] <= limit) {
                lt++;
            }
            boat++;
        }
        
        return boat;
    }
}