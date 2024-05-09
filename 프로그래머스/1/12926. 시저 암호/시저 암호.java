class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(Character.isLowerCase(ch[i])) {
                ch[i] = (char) ((ch[i] + n) % 'a' % 26 + 'a');
            } else if(Character.isUpperCase(ch[i])) {
                ch[i] = (char) ((ch[i] + n) % 'A' % 26 + 'A');
            }
        }
        
        return String.valueOf(ch);
    }
}