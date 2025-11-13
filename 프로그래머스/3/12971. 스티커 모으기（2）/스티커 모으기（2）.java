class Solution {
    public int solution(int sticker[]) {

        int n = sticker.length;
        
        if(n == 1) {
            return sticker[0];
        }
        
        
        // case 1 : sticker[0] 뜯는 경우
        int[] dp1 = new int[n];
        
        dp1[0] = sticker[0];
        dp1[1] = dp1[0]; // 첫 스티커 뜯었으므로, 두 번째는 못 뜯음.
        
        for(int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        
        int answer1 = dp1[n - 2];
        
        // case 2 : sticker[0] 뜯지 않는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        int answer2 = dp2[n - 1];
        
        return Math.max(answer1, answer2);
    }
}