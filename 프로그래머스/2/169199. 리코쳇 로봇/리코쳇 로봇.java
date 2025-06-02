import java.util.*;

class Solution {
    
    class Point {
        int y;
        int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(String[] board) {
        
        int n = board.length;
        int m = board[0].length();
        
        Queue<Point> queue = new LinkedList<>();
        
        Point target = null;
        
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                } else if(board[i].charAt(j) == 'G') {
                    target = new Point(i, j);
                }
            }
        }
        
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point current = queue.poll();
                for(int d = 0; d < 4; d++) {
                    Point next = move(current, d, n, m, board);
                    if(next.y == target.y && next.x == target.x) {
                        return level;
                    }
                    
                    if(!visited[next.y][next.x]) {
                        visited[next.y][next.x] = true;
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    public Point move(Point current, int d, int n, int m, String[] board) {
        int[] dy = {1, 0, -1 , 0};
        int[] dx = {0, 1, 0, -1};
        
        int ny = current.y + dy[d];
        int nx = current.x + dx[d];
        
        while(ny >= 0 && nx >= 0 && ny < n && nx < m && board[ny].charAt(nx) != 'D') {
            ny += dy[d];
            nx += dx[d];
        }
        
        ny -= dy[d];
        nx -= dx[d];
        
        return new Point(ny, nx);
    }
}