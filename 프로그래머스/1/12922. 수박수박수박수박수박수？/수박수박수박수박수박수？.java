class Solution {
    public String solution(int n) {
        String answer = "수박";
        
        if(n == 1) return "수";
        else if(n==2) return answer;
        else {
            for(int i =2; i < n; i++) {
                answer += answer.charAt(i-2);
            }
        }
        
        
        return answer;
    }
}