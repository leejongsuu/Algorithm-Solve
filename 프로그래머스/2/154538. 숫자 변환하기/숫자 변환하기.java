import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        final int INF = 1000001;
        boolean[] visited = new boolean[INF];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                if(current == y) {
                    return level;
                }
                
                int[] nexts = {current + n, current * 2, current * 3};
                for(int next : nexts) {
                    if(next < INF && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}