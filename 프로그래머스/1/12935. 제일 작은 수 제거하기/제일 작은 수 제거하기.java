import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        
        // 배열 길이가 1인 경우, -1을 포함하는 배열을 반환한다.
        if(arr.length == 1) {
            return new int[]{-1};
        }
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = new int[arr.length-1];
        
        for(int i = 0, j=0; j < answer.length; i++) {
            if(arr[i] == min) continue;
            answer[j++] = arr[i];
        }
        
        return answer;
    }
}