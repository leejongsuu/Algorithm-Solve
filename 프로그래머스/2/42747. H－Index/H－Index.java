import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        
        int len = citations.length;
        
        Arrays.sort(citations);
        
        int lo = 0;
        int hi = citations[len - 1];
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            
            int cnt = 0;
            for(int i : citations) {
                if(i>=mid) cnt++;
            }
            
            if(cnt >= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo > 0 ? lo - 1 : 0;
    }
}