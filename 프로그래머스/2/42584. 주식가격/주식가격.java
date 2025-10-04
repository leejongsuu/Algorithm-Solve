class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            result[i] = (n - i - 1);
        }
        
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(prices[i] > prices[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        
        return result;
    }
}