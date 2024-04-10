import java.util.*;

class Solution {
    
    class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        int[][] board = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j]=maps[i][j];
            }
        }
        
        answer = BFS(n, m, board);
        
        return answer;
    }
    
    public int BFS(int n, int m, int[][] board) {
        
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        
        board[0][0] = 0;
        
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0,0));
        
        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point current = Q.poll();
                if(current.y == n-1 && current.x == m-1) {
                    return level + 1;
                }
                for(int j=0; j<4; j++) {
                    int ny = current.y + dy[j];
                    int nx = current.x + dx[j];
                    
                    if(ny>=0 && nx>=0 && ny<n && nx<m && board[ny][nx] == 1) {
                        board[ny][nx] = 0;
                        Q.offer(new Point(ny, nx));
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}