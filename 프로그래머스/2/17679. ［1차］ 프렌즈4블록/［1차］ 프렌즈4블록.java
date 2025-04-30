import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        
        char[][] boards = new char[m][n];
        for(int i = 0; i < m; i++ ){
            boards[i] = board[i].toCharArray();
        }
        
        int result = 0;
        
        while(true) {
            boolean isBreak = false;
            boolean[][] visited = new boolean[m][n];
            for(int r = 0; r < m - 1; r++) {
               for(int c = 0; c < n - 1; c++) {
                   char target = boards[r][c];
                   if(target == '.') continue;
                    if(boards[r][c+1] == target && boards[r+1][c] == target && boards[r+1][c+1] == target) {
                        isBreak = true;
                        visited[r][c] = visited[r][c+1] = visited[r+1][c] = visited[r+1][c+1] = true;
                    }
                }
            }
            
            if(!isBreak) {
                break;
            } else {
                result += countingAndUpdate(m, n, boards, visited);
                updatePosition(m, n, boards);
            }
        }
        return result;
    }
    
    int countingAndUpdate(int m, int n, char[][] boards, boolean[][] visited) {
        int count = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(visited[r][c]){
                    boards[r][c] = '.';
                    count++;
                } 
            }
        }
        return count;
    }
    
    void updatePosition(int m, int n, char[][] boards) {
        for(int c = 0; c < n; c++) {
            for(int r = m - 1; r > 0; r--) {
                if(boards[r][c] == '.') {
                    int nr = r - 1;
                    while(nr > 0 && boards[nr][c] == '.') {
                        nr--;
                    }
                    boards[r][c] = boards[nr][c];
                    boards[nr][c] = '.';
                }
            }
        }
    }
}