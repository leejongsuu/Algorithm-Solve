import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        
        if(n > s) {
            return new int[]{-1};
        }
        
        int base = s / n;
        int remain = s % n;
        
        int[] result = new int[n];
        Arrays.fill(result, base);
        
        for(int i = 1; i <= remain; i++) {
            result[n - i]++;
        }
        
        return result;
    }
}