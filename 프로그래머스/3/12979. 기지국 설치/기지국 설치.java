class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int idx = 0;
        
        for(int apart = 1; apart <= n; apart += 2 * w + 1) {
            while(idx < stations.length && apart >= (stations[idx] - w) && apart <= stations[idx] + w) {
                apart = stations[idx] + w + 1;
                idx++;
            }
            
            if(apart <= n) {
                answer++;
            }
        }
        
        return answer;
    }
}