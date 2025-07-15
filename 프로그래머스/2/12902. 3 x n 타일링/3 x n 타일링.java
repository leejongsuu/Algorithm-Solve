class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        
        if(n % 2 == 1) return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if(n > 2) dp[2] = 3;
        
        for(int i = 4; i <= n; i++) {
            dp[i] = (int) (4L * dp[i - 2] % MOD - dp[i - 4] + MOD) % MOD;
        }
        
        return dp[n];
    }
}