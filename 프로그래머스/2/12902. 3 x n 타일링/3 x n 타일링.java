class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        
        if ((n & 1) == 1) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        if (n >= 2) dp[2] = 3;

        
        for (int i = 4; i <= n; i += 2) {
            // 4*dp[i-2] - dp[i-4], 음수 방지를 위해 +MOD
            long v = (4L * dp[i - 2] % MOD - dp[i - 4] + MOD) % MOD;
            dp[i] = (int) v;
        }

        return dp[n];
    }
}