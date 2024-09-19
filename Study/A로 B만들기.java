class Solution {
    public int solution(String before, String after) {
        
        int[] alphabet = new int[26];
        for(char c : before.toCharArray()) {
            alphabet[c - 'a']++;
        }
        
        for(char c : after.toCharArray()) {
            if(alphabet[c - 'a'] > 0) {
                alphabet[c - 'a']--;
            } else {
                return 0;
            }
        }
        
        return 1;
    }
}
