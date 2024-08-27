import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        
        int len = s.length();
        int[] result = new int[len];
        
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(alphabet[index] == -1) {
                result[i] = -1;
            } else {
                result[i] = i - alphabet[index];    
            }
            alphabet[index] = i;
        }
        
        return result;
    }
}