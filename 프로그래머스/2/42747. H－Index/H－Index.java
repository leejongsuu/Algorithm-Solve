import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        int maxH = 0;
        for (int i = 0; i < n; i++) {
            int h = Math.min(citations[i], n - i);
            maxH = Math.max(maxH, h);
        }
        
        return maxH;
    }
}