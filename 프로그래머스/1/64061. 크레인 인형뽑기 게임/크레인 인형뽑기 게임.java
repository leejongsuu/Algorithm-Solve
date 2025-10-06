import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int result = 0;
        
        int n = board.length;
        
        Stack<Integer>[] dolls = new Stack[n];
        for(int i = 0; i < n; i++) {
            dolls[i] = new Stack<>();
            for(int j = n - 1; j >= 0 ; j--) {
                if(board[j][i] != 0) {
                    dolls[i].push(board[j][i]);
                }
            }
        }
        
        Stack<Integer> picks = new Stack<>();
        
        for(int move : moves) {
            if(dolls[move - 1].isEmpty()) {
               continue; 
            }
            
            int doll = dolls[move - 1].pop();
            if(!picks.isEmpty() && picks.peek() == doll) {
                picks.pop();
                result += 2;
            } else {
                picks.push(doll);
            }
        }
        return result;
    }
}