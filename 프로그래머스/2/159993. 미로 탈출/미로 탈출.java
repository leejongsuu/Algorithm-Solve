import java.util.*;

class Solution {
    
    class Point {
        int r;
        int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        Point start = null;
        Point lever = null;
        Point exit = null;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'S') {
                    start = new Point(i, j);
                } else if(maps[i].charAt(j) == 'L') {
                    lever = new Point(i, j);
                } else if(maps[i].charAt(j) == 'E') {
                    exit = new Point(i, j);
                }
            }
        }
        
        int leverCount = bfs(n, m, start, lever, maps);
        if(leverCount == -1) {
            return -1;
        }
        
        int exitCount = bfs(n, m, lever, exit, maps);
        if(exitCount == -1) {
            return -1;
        }
        
        return leverCount + exitCount;
    }
    
    int bfs(int n, int m, Point s, Point e, String[] maps) {
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(s.r, s.c));
        
        boolean[][] visited = new boolean[n][m];
        visited[s.r][s.c] = true;
        
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point current = queue.poll();
                if(current.r == e.r && current.c == e.c) {
                    return level;
                }
                
                for(int d = 0; d < 4; d++) {
                    int nr = current.r + dr[d];
                    int nc = current.c + dc[d];
                    
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
                        continue;
                    }
                    
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
            level++;
        }
        return -1;
    }
}