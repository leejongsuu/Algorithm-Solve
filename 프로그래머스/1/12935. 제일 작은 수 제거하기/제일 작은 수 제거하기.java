import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        
        int size = arr.length - 1;
        if(size == 0) {
            return new int[]{-1};
        }
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] result = new int[size];
        for(int i = 0, j = 0; j < size; i++) {
            if(arr[i] == min) continue;
            result[j++] = arr[i];
        }
        
        return result;
    }
}