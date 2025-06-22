import java.util.*;

class Solution {

    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        
        char[][] ch = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                ch[i][j] = board[i].charAt(j);
                if(ch[i][j] == 'O') oCount++;
                else if(ch[i][j] == 'X') xCount++;
            }
        }
        
        boolean oFlag = isCheck(ch, 'O');
        boolean xFlag = isCheck(ch, 'X');
        
        int dis = oCount - xCount;
        
        if(!(dis == 0 || dis == 1)) {
            return 0;
        }
        
        if(oFlag) {
            if(dis == 0) {
                return 0;
            }
        }
        
        if(xFlag) {
            if(dis == 1) {
                return 0;
            }
        }
        
        return 1;
    }
    
    boolean isCheck(char[][] ch, char target) {
        for(int i = 0; i < 3; i++) {
            if(ch[i][0] == target && ch[i][1] == target && ch[i][2] == target) {
                return true;
            }
            
            if(ch[0][i] == target && ch[1][i] == target && ch[2][i] == target) {
                return true;
            }
        }
        
        if(ch[0][0] == target && ch[1][1] == target && ch[2][2] == target) {
            return true;
        }
        
        if(ch[0][2] == target && ch[1][1] == target && ch[2][0] == target) {
            return true;
        }
        
        return false;
    }
}