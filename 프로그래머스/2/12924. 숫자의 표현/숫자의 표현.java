class Solution {
    public int solution(int n) {
        
        int result = 0;
        int sum = 0;
        
        for(int lt = 1, rt = 1; rt <=n; rt++) {
            sum += rt;
            while(sum > n) {
                sum -= lt;
                lt++;
            }
            
            if(sum == n) {
                result++;
            }
        }
        
        return result;
    }
}