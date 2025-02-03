import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        Queue<Integer>[] machineQueues = new Queue[N];
        for(int i = 0; i < N; i++) {
            machineQueues[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 0) {
                    machineQueues[j].add(board[i][j]);
                }
            }
        }
        
        int result = 0;
        Stack<Integer> basketStack = new Stack<>();
        for(int move : moves) {
            if(!machineQueues[move - 1].isEmpty()) {
                int doll = machineQueues[move - 1].poll();
                if(!basketStack.isEmpty() && basketStack.peek() == doll) {
                    basketStack.pop();
                    result += 2;
                } else {
                    basketStack.push(doll);
                }
            }
        }
        
        return result;
    }
}