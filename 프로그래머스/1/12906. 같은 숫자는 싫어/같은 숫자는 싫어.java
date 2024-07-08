import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int before = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr) {
            if(num != before) {
                list.add(num);
                before = num;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}