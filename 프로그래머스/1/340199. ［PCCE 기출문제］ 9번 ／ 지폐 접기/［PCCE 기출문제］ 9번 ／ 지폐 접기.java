class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int result = 0;
        
        int max_wallet = Math.max(wallet[0], wallet[1]);
        int min_wallet = Math.min(wallet[0], wallet[1]);
        
        int max = bill[0];
        int min = bill[1];
        
        while(true) {
            if(min > max) {
                int temp = min;
                min = max;
                max = temp;
            }
            
            if(max > max_wallet || min > min_wallet) {
                result++;
                max /= 2;
                continue;
            }
            
            return result;
        }
    }
}