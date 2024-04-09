import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];
            list.get(s).add(e);
            list.get(e).add(s);
        }
        
        answer = BFS(n, list);
        
        return answer;
    }
    
    public int BFS(int n, ArrayList<ArrayList<Integer>> list) {
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        
        int cnt = 1;
        while(!Q.isEmpty()) {
            cnt = Q.size();
            for(int i=0; i < cnt; i++) {
                int now = Q.poll();
                for(int next : list.get(now)){
                    if(!visited[next]) {
                        visited[next] = true;
                        Q.offer(next);
                    }
                }
            }
        }
        return cnt;
    }
}