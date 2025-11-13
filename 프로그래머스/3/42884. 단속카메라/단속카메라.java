import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        int result = 0;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int before = -30_001;
        
        for(int[] route : routes) {
            int in = route[0];
            int out = route[1];
            
            if(in > before) {
                result++;
                before = out;
            }
        }
        
        return result;
    }
}