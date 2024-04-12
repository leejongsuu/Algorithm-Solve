import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        
        int answer = 0;
        
        int[] student = new int[n+2];
        for(int r : reserve) {
            int index = Arrays.binarySearch(lost, r);
            if(index < 0) {
                student[r]++;
            } else {
                lost[index] = -1;
            }
        }
        
        for(int l : lost) {
            if(l==-1) continue;
            
            if(student[l-1] > 0) {
                student[l-1]--;
            } else if(student[l+1] > 0) {
                student[l+1]--;
            } else {
                student[l]--;
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(student[i] >= 0) answer++;
        }
        
        return answer;
    }
}