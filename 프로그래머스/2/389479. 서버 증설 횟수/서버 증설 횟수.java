class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int active = 0;
        
        int[] server = new int[24];
        
        for(int i = 0; i < 24; i++) {
            if(i >= k) {
                active -= server[i - k];
            }
            
            int req = players[i] / m;
            if(req > active) {
                int add = req - active;
                answer += add;
                active += add;
                server[i] = add;
            }
        }
        
        return answer;
    }
}