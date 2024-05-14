import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for(int i = 0; i < answer.length; i++) {
            int start = commands[i][0] -1;
            int end = commands[i][1];
            int index = commands[i][2] -1;
            int[] subArr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArr);
            answer[i] = subArr[index];
        }
        
        return answer;
    }
}