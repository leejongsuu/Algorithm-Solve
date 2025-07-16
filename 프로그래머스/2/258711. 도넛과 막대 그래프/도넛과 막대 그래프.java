import java.util.*;

class Solution {
    
    int vCnt, eCnt;
    boolean[] visited;
    
    public int[] solution(int[][] edges) {
        int[] result = new int[4];
        
        int n = 0;
        for(int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        
        List<Integer>[] lists = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            outdegree[u]++;
            indegree[v]++;
            lists[u].add(v);
        }
        
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0 && outdegree[i] > 1) {
                result[0] = i;
                break;
            }
        }
        
        for(int i : lists[result[0]]) {
            vCnt = 0;
            eCnt = 0;
            visited = new boolean[n + 1];
            dfs(i, lists);
            int dis = vCnt - eCnt;
            if(dis == 0) result[1]++;
            else if(dis == 1) result[2]++;
            else if(dis == -1) result[3]++;
        }
    
        return result;
    }
    
    void dfs(int v, List<Integer>[] lists) {
        vCnt++;
        eCnt += lists[v].size();
        visited[v] = true;
        
        for(int next : lists[v]) {
            if(!visited[next]) {
                dfs(next, lists);
            }
        }
    }
}