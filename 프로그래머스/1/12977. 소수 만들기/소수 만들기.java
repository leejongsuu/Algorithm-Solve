class Solution {
    
    static int result = 0;
    
    public int solution(int[] nums) {
        DFS(0, 0, 0, nums);
        return result;
    }
    
    private void DFS(int L, int start, int sum, int[] nums) {
        if(L == 3) {
            if(isPrime(sum)) {
                result++;
            }
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            DFS(L+1, i+1, sum + nums[i], nums);
        }
    }
    
    private boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}