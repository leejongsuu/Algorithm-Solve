class Solution {
    
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
    
        
        int result = DFS(0, 0, len, numbers, target);
        
        return result;
    }
    
    private int DFS(int L, int sum, int len, int[] numbers, int target) {
        if(len == L) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }        
        
        return DFS(L + 1, sum + numbers[L], len, numbers, target) + DFS(L + 1, sum - numbers[L], len, numbers, target);
        
    }
}