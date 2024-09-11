import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int boom = 0;
        int n = board.length;
        
        Stack<Integer> drawStack = new Stack<>();
        Stack<Integer>[] boardStack = new Stack[n];
        for(int i = 0; i < n; i++) {
            boardStack[i] = new Stack<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(board[j][i] != 0) {
                    boardStack[i].push(board[j][i]);
                }
            }
        }
        
        for(int move : moves) {
            if(boardStack[move - 1].isEmpty()) continue;
            
            int draw = boardStack[move - 1].pop();
            if(!drawStack.isEmpty() && drawStack.peek() == draw) {
                boom += 2;
                drawStack.pop();
            } else {
                drawStack.push(draw);
            }
        }
        
        return boom;
    }
}