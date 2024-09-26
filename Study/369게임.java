class Solution {
    public int solution(int order) {
        
        int result = 0;
        
        for(char num : String.valueOf(order).toCharArray()) {
            if(num != '0' && (num - '0') % 3 == 0) {
                result++;
            }
        }
        
        return result;
    }
}
