class Solution {
    public String solution(String s) {
        
        char[] ch = s.toLowerCase().toCharArray();
        
        int dis = 'a' - 'A';
        
        for(int i = 0, j = 0; i < s.length(); i++, j++) {
            if(ch[i] == ' ') {
                j = -1;
                continue;
            }
            if(j % 2 == 0) {
                ch[i] -= dis;
            }
        }
        
        return String.valueOf(ch);
    }
}