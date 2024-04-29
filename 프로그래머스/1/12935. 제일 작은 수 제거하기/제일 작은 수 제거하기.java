import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) {
            return new int[]{-1};
        }
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = new int[arr.length-1];
        
        for(int i = 0, j=0; j < answer.length; i++) {
            if(arr[i] == min) {
                min = Integer.MIN_VALUE;
                continue;
            }
            answer[j++] = arr[i];
        }
        
        return answer;
    }
}