class Solution {
    public int solution(int storey) {
        
        int ans = 0;
        while(storey > 0) {
            int d = storey % 10;
            if(d < 5) {
                ans += d;
                storey /= 10;
            } else if(d > 5) {
                ans += 10 - d;
                storey = (storey / 10) + 1;
            } else {
                ans += d;
                int q = (storey / 10) % 10;
                if(q >= 5) {
                    storey = (storey / 10) + 1;
                } else {
                    storey /= 10;
                }
            }
        }
        
        return ans;
    }
}