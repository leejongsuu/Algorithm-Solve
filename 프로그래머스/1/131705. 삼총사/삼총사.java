class Solution {
    
    static int count = 0;
    
    public int solution(int[] number) {
        DFS(0, 0, 0, number, number.length);
        return count;
    }
    
    private void DFS(int L, int sum, int start, int[] number, int len) {
        if(L == 3) {
            if(sum == 0) count++;
            return;
        }
        
        for(int i = start; i < len; i++) {
            DFS(L+1, sum + number[i], i + 1, number, len);
        }
    }
}