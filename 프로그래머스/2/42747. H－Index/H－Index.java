import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int lo = 0;
        int hi = Arrays.stream(citations).max().getAsInt();
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;
            for(int i : citations) {
                if(i>=mid) cnt++;
            }
            
            if(cnt>=mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        if(lo == 0) {
            answer = 0;
        } else {
            answer = lo -1;
        }
        
        return answer;
    }
}