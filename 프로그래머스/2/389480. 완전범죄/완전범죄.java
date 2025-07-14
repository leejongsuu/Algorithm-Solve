class Solution {
     public int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];
            boolean[][] next = new boolean[n][m];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[a][b]) continue;
                    // 1) A가 훔치기
                    int na = a + aCost;
                    int nb = b;
                    if (na < n) {
                        next[na][nb] = true;
                    }
                    // 2) B가 훔치기
                    na = a;
                    nb = b + bCost;
                    if (nb < m) {
                        next[na][nb] = true;
                    }
                }
            }
            dp = next;
        }

        // 가능한 상태 중에서 A 흔적 최소값 찾기
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b]) {
                    return a;
                }
            }
        }
        // 불가능하면 -1
        return -1;
    }
}