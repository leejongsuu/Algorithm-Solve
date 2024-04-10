class Solution {
    
    public int solution(int[] numbers, int target) {
        
        return DFS(0, 0, numbers, target);
    }
    
    public int DFS(int L, int sum, int[] numbers, int target) {
             
        if(L==numbers.length){
            if(sum == target) {
                return 1;
            }
            return 0;
        } else {
            return DFS(L+1, sum + numbers[L], numbers, target) +
                DFS(L+1, sum - numbers[L], numbers, target);
        }
    }
}