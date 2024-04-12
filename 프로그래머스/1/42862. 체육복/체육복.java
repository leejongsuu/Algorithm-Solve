import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        
        int answer = n;
        
        int[] person = new int[n+2];
        for(int l : lost) person[l]--;
        for(int r : reserve) person[r]++;
        
        for(int i=1; i<=n; i++) {
            if(person[i] == -1) {
                if(person[i-1] == 1) {
                    person[i-1]--;
                    person[i]++;
                } else if(person[i+1] == 1) {
                    person[i+1]--;
                    person[i]++;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}