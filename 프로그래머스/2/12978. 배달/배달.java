import java.util.*;

class Solution {
    
    class Edge {
        int e, w;
        
        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
    
    static int result = 1;
    static int[] dp;
    static List<Edge>[] viliages;
    static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        
        viliages = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            viliages[i] = new ArrayList<>();
        }
        
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        visited = new boolean[N + 1];
        visited[1] = true;
        
        for(int[] info : road) {
            int s = info[0];
            int e = info[1];
            int w = info[2];
            viliages[s].add(new Edge(e, w));
            viliages[e].add(new Edge(s, w));
        }
        
        dfs(1, K);
        
        return result;
    }
    
    void dfs(int current, int k) {
        for(Edge next : viliages[current]) {
            if(dp[current] + next.w <= k) {
                if(!visited[next.e]) {
                    result++;
                    visited[next.e] = true;
                }
                if(dp[current] + next.w < dp[next.e]) {
                    dp[next.e] = dp[current] + next.w;
                    dfs(next.e, k);
                }
            }
        }
    }
}