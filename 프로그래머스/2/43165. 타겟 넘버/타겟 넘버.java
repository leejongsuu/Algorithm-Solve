class Solution {
    
    static int way = 0;
    static int len = 0;
    public int solution(int[] numbers, int target) {
        
        len = numbers.length;
        DFS(0, 0, numbers, target);
        
        return way;
    }
    
    public void DFS(int L, int sum, int[] numbers, int target) {
        if(L == len) {
            if(sum == target) way++;
        } else {
            DFS(L+1, sum + numbers[L], numbers, target);
            DFS(L+1, sum - numbers[L], numbers, target);
        }
    }
}