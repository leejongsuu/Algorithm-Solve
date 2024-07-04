class Solution {
    
    public int[] solution(long n) {
        
        String numStr = String.valueOf(n);
        int len = numStr.length();
        
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            answer[len - i - 1] = numStr.charAt(i) - '0';
        }
        
        return answer;
    }
}