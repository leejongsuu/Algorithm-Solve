import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int N = board.length;
        Stack<Integer>[] stack = new Stack[N + 1];
        for(int i = 0; i<=N; i++) stack[i] = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            for(int j = N - 1; j >= 0; j--) {
                if(board[j][i] == 0) continue;
                stack[i + 1].push(board[j][i]);
            }
        }
        
        Stack<Integer> result = new Stack<>();
        for(int m : moves) {
            if(stack[m].isEmpty()) continue;
            
            int n = stack[m].pop();
            if(result.isEmpty()) {
                result.push(n);
            }
            else if(result.peek() == n) {
                result.pop();
                answer+=2;
            } else {
                result.push(n);
            }               
        }
        
        return answer;
    }
}