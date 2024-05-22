class Solution {
    
    static int answer = 0;
    
    public int solution(int[] nums) {
        int len = nums.length;
        DFS(0, 0, 0, len, nums);
        return answer;
    }
    
    private void DFS(int L, int sum, int start, int len, int[] nums) {
        
        if(L == 3) {
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i < len; i++) {
            DFS(L+1, sum + nums[i], i+1, len, nums);
        }
    }
    
    private boolean isPrime(int n) {
        
        if(n == 1 || n % 2 == 0) return false;
        
        for(int i = 3; i < n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}