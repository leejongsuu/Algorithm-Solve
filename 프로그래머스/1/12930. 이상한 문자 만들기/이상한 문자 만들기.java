class Solution {
    public String solution(String s) {
        
        char[] ch = s.toCharArray();
        for(int i = 0, j = 0; i < s.length(); i++, j++) {
            if(ch[i] == ' ') {
                j = -1;
                continue;
            }
             
            if(j % 2 == 0) {
                ch[i] = Character.toUpperCase(ch[i]);
            } else {
                ch[i] = Character.toLowerCase(ch[i]);
            }
        }
        return String.valueOf(ch);
    }
}