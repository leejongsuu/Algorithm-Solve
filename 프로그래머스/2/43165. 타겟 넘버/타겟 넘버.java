class Solution {
    
    int len;
    int result;
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        result = 0;
        
        DFS(0, 0, numbers, target);
        
        return result;
    }
    
    private void DFS(int L, int sum, int[] numbers, int target) {
        if(len == L) {
            if(sum == target) {
                result++;
            }
            return;
        }        
        
        DFS(L + 1, sum + numbers[L], numbers, target);
        DFS(L + 1, sum - numbers[L], numbers, target);
    }
}