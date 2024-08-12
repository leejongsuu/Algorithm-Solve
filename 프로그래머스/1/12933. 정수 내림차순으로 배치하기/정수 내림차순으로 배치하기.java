import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] ch = String.valueOf(n).toCharArray();
        Arrays.sort(ch);
        
        StringBuilder sb = new StringBuilder(String.valueOf(ch));
        return Long.parseLong(sb.reverse().toString());
    }
}