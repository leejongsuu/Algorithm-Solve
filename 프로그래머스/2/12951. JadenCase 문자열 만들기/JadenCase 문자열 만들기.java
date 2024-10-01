class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStartOfWord = true;
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                isStartOfWord = true;
                sb.append(c);
            } else {
                if(isStartOfWord) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isStartOfWord = false;
            }
        }
        
        return sb.toString();
    }
}