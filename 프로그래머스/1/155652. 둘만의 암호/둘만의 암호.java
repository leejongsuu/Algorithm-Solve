import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        
        int len = s.length();
        char[] result = new char[len];
        
        HashSet<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int cnt = 0;
            while(cnt < index) {
                c = (char) ((int) c + 1);
                if(c > 'z') c = 'a';
                
                if(skipSet.contains(c)) continue;
                else cnt++;
            }
            result[i] = c;
        }
        
        return String.valueOf(result);
    }
}