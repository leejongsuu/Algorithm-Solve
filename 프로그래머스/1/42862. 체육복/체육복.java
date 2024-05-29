class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] result = new int[n+2];
        for(int i : lost) result[i]--;
        for(int i : reserve) result[i]++;
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(result[i] < 0) {
                if(result[i-1] > 0) {
                    result[i-1]--;
                    result[i]++;
                } else if(result[i+1] > 0) {
                    result[i+1]--;
                    result[i]++;
                }
            }
            
            if(result[i] >= 0) answer++;
        }
        
        return answer;
    }
}