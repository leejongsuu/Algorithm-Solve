import java.util.*;

class Solution {
    
    int vCnt, eCnt;
    boolean[] visited;
    List<Integer>[] lists;
    
    public int[] solution(int[][] edges) {
        
        int n = 1;
        for(int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        
        lists = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        visited = new boolean[n + 1];
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            outdegree[u]++;
            indegree[v]++;
            
            lists[u].add(v);
        }
        
        int fgv = 0;
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0 && outdegree[i] >= 2) {
                fgv = i;
                break;
            }
        }
        
        int donut = 0, stick = 0, eight = 0;
        for(int i : lists[fgv]) {
            vCnt = 0;
            eCnt = 0;
            dfs(i, lists);
            
            int diff = vCnt - eCnt;
            if(diff == 0) donut++;
            else if(diff == 1) stick++;
            else if(diff == -1) eight++;
        }
        
        return new int[]{fgv, donut, stick, eight};
    }
    
    void dfs(int v, List<Integer>[] lists) {
        visited[v] = true;
        vCnt++;
        eCnt += lists[v].size();
        
        for(int next : lists[v]) {
            if(!visited[next]) {
                dfs(next, lists);
            }
        }
    }
}