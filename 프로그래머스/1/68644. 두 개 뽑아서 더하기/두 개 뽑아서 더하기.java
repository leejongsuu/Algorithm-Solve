import java.util.TreeSet;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numbers) {
        
        TreeSet<Integer> numberSet = new TreeSet<>();
        
        int len = numbers.length;
        
        for(int i = 0; i < len -1; i++) {
            for(int j = i + 1; j < len; j++) {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }
        
        return numberSet.stream().mapToInt(Integer::intValue).toArray();
    }
}