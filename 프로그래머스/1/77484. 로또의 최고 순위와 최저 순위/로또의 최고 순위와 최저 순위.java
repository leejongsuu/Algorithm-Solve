import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        HashSet<Integer> winSet = new HashSet<>();
        for(int i : win_nums) winSet.add(i);
        
        int zero_count = 0;
        int correct = 0;
        for(int i : lottos) {
            if(winSet.contains(i)) {
                correct++;
            } else if(i == 0) {
                zero_count++;
            }
        }
    
        int high = 7 - (correct + zero_count);
        int low = 7 - correct;
        
        if(high > 6) high = 6;
        if(low > 6) low = 6;
        
        return new int[]{high, low};
    }
}