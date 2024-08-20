import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        
        int count = 0;
        int sum = 0;
        for(int cost : d) {
            if(sum + cost > budget) {
                break;
            } else {
                sum += cost;
                count++;
            }
        }
        
        return count;
    }
}