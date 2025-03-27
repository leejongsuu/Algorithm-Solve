import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int lo = 0;
        int hi = Arrays.stream(citations).max().getAsInt();
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;
            for(int citation : citations) {
                if(citation >= mid) {
                    cnt++;
                }
            }
            if(cnt >= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo == 0 ? 0 : lo - 1;
    }
}