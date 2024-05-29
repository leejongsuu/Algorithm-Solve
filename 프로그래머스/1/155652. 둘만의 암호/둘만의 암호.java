class Solution {
    public String solution(String s, String skip, int index) {
        
        char[] alphabet = new char[26];
        for(int i = 0; i < 26; i++) {
            alphabet[i] = (char) ((int) 'a' + i);
        }
        for(int i = 0; i < skip.length(); i++) {
            alphabet[skip.charAt(i) -'a'] = '0';
        }
        
        int len = s.length();
        char[] result = new char[len];
        
        for(int i = 0; i < len; i++) {
            char word = s.charAt(i);
            int cnt = 0;
            int j = word - 'a';
            while (cnt < index) {
                j = (j+1) % 26;
                if(alphabet[j] != '0') {
                    cnt++;
                }
            }
            result[i] = alphabet[j];
        }
        
        return String.valueOf(result);
    }
}