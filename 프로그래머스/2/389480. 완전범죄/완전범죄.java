class Solution {
    public int solution(int[][] info, int n, int m) {
        
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        
        for(int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];
            boolean[][] next = new boolean[n][m];
            
            for(int a = 0; a < n; a++) {
                for(int b = 0; b < m; b++) {
                    if(!dp[a][b]) continue;
                    
                    int na = a + aCost;
                    int nb = b + bCost;
                    
                    if(na < n) {
                        next[na][b] = true;
                    }
                    
                    if(nb < m) {
                        next[a][nb] = true;
                    }
                }
            }
            
            dp = next;
        }
        
        for(int a = 0; a < n; a++) {
            for(int b = 0; b < m; b++) {
                if(dp[a][b]) return a;
            }
        }
        
        return -1;
    }
}