class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        boolean isStartOfWord  = true;
        
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ' ') {
                isStartOfWord = true;
                continue;
            } else {
                if(isStartOfWord) {
                    ch[i] = Character.toUpperCase(ch[i]);
                } else {
                    ch[i] = Character.toLowerCase(ch[i]);
                }
                isStartOfWord = false;
            }
        }
        
        return String.valueOf(ch);
    }
}