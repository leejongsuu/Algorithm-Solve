class Solution {
    public int solution(int storey) {
        
        int ans = 0;
        while(storey > 0) {
            int d = storey % 10; // 일의 자리
            int q = (storey / 10) % 10; // 다음 자리(10의 자리)
            
            if(d < 5) {
                ans += d;
                storey /= 10;
            } else if(d > 5) {
                ans += 10 - d;
                storey = storey / 10 + 1;
            } else {
                ans += 5;
                if(q >= 5) {
                    storey = storey / 10 + 1;
                } else {
                    storey /= 10;
                }
            }
        }
        return ans;
    }
}