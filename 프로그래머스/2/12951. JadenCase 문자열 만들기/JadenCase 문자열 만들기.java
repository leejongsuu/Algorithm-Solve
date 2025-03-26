class Solution {
    public String solution(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        
        boolean firstWord = true;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ' ') {
                firstWord = true;
                continue;
            }
            
            if(firstWord) {
                if(Character.isAlphabetic(ch[i])) {
                    ch[i] = Character.toUpperCase(ch[i]);
                }
                firstWord = false;
            }
        }
        
        return String.valueOf(ch);
    }
}