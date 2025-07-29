import java.util.*;

class Solution {
    List<int[]> answerList = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return answerList.toArray(new int[answerList.size()][]);
    }
    
    void hanoi(int n, int from, int to, int via) {
        if(n == 1) {
            answerList.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, via, to);
        answerList.add(new int[]{from, to});
        hanoi(n - 1, via, to, from);
    }
}