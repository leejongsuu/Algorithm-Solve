import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int len = commands.length;
        int[] result = new int[len];
        
        for(int i = 0; i < len; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int index = commands[i][2] - 1;
            
            int[] temp = Arrays.copyOfRange(array, start, end);
            
            Arrays.sort(temp);

            result[i] = temp[index];
        }
        
        return result;
    }
}