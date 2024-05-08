class Solution {
    
    static int answer = 0;
    
    public int solution(int[] number) {
        DFS(0, 0, 0, number);
        return answer;
    }
    
    private void DFS(int L, int start, int sum, int[] number) {
        
        if(L == 3) {
            if(sum == 0) answer++;
        } else {
            for(int i=start; i<number.length; i++) {
                DFS(L+1, i+1, sum + number[i], number);
            }
        }
    }
}