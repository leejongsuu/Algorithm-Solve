import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr) {
            if(num % divisor == 0) {
                list.add(num);
            }
        }
        
        Collections.sort(list);
        
        return list.size() == 0 
            ? new int[]{-1}
            : list.stream().mapToInt(Integer::intValue).toArray();
    }
}