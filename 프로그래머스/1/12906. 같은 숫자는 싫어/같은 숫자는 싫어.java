import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int before = -1;
        
        for(int n : arr) {
            if(n != before) {
                list.add(n);
                before = n;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}