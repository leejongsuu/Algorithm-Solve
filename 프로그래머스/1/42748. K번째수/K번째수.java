import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int size = commands.length;
        int[] result = new int[size];
        
        for(int i = 0; i < size; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int pos = commands[i][2] - 1;
            
            int[] sub = Arrays.copyOfRange(array, start, end);
            Arrays.sort(sub);
            
            result[i] = sub[pos];
        }
        
        return result;
    }
}