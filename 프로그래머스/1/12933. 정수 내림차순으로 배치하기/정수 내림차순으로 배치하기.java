import java.util.Arrays;

class Solution {
    
    public long solution(long n) {

        char[] ch = String.valueOf(n).toCharArray();
        
        Arrays.sort(ch);
        
        return Long.parseLong(new StringBuilder(String.valueOf(ch)).reverse().toString());
        
    }
}