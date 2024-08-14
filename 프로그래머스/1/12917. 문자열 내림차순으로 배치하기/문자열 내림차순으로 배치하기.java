import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        
        return new StringBuilder(String.valueOf(ch)).reverse().toString();
    }
}