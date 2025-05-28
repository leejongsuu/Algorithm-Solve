class Solution {
    public int solution(int[] players, int m, int k) {
        
        int result = 0;
        int active = 0;
        
        int[] server = new int[24];
        for(int t = 0; t < 24; t++) {
            if(t >= k) {
                active -= server[t - k];
            }
            
            int req = players[t] / m;
            if(active < req) {
                int add = req - active;
                result += add;
                active += add;
                server[t] = add;
            }
        }
        
        return result;
    }
}