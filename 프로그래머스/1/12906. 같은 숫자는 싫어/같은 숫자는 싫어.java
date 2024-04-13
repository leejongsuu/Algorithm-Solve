import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        
        int before = -1;
        for(int i : arr) {
            if(i==before) continue;
            
            list.add(i);
            before = i;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}