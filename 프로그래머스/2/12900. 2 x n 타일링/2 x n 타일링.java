class Solution {
    public int solution(int n) {
        
        final int mod = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        
        return dp[n];
    }
}