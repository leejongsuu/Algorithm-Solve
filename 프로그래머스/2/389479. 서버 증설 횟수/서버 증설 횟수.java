class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        int active = 0;
        
        int[] server = new int[24];
        
        for(int i = 0; i < 24; i++) {
            if(i >= k) {
                active -= server[i - k];
            }
            
            int req = players[i] / m;
            if(active < req) {
                int add = req - active;
                result += add;
                active += add;
                server[i] = add;
            }
        }
        
        return result;
    }
}