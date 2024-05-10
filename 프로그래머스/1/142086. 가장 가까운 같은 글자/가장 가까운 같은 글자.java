import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            
            if(alphabet[pos] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - alphabet[pos];
            }
            alphabet[pos] = i;
        }
        return answer;
    }
}