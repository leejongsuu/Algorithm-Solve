import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int result = 1;
        int sum = 0;
        int count = 0;
            
        int lt = 0;
        int rt = people.length - 1;
        while(lt <= rt) {
            if(count + 1 <= 2) {
                count++;
                if(sum + people[rt] <= limit) {
                    sum += people[rt];
                    rt--;
                } else if(sum + people[lt] <= limit) {
                    sum += people[lt];
                    lt++;
                } else {
                    result++;
                    sum = 0;
                    count = 0;
                }
            } else {
                result++;
                sum = 0;
                count =0;
            }
        }
        
        return result;
    }
}