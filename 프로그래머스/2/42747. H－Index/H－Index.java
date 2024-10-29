import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        int len = citations.length;
        int lo = 0;
        int hi = citations[len - 1];
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = len;
            for(int c : citations) {
                if(c < mid) {
                    cnt--;
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