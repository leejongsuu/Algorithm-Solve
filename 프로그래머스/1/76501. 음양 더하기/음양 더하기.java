class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
            int sign = signs[i] == true ? 1 : -1;
            result += absolutes[i] * sign;
        }
        
        return result;
    }
}