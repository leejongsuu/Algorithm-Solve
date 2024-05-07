class Solution {
    public String solution(String s) {

        String answer = "";
        
        s = s.toLowerCase();
        int dis = 'a' - 'A';
        for(int i = 0, j = 0; i < s.length(); i++, j++) {
            if(s.charAt(i) == ' ') {
                j = -1;
                answer += ' ';
                continue;
            }
            
            if(j % 2 == 0) {
                answer += (char) (s.charAt(i) - dis);
            } else {
                answer += s.charAt(i);
            }
        }
        
        return answer;
    }
}