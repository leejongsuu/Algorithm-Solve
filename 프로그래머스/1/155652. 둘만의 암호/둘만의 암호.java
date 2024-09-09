class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] alphabet = new boolean[26];
        for(char c : skip.toCharArray()) {
            alphabet[c - 'a'] = true;
        }
        
        int len = s.length();
        char[] result = new char[len];
        for(int i = 0; i < len; i++) {
            char word = s.charAt(i);
            int j = word - 'a';
            int cnt = 0;
            while(cnt < index) {
                if(!alphabet[(++j) % 26]) {
                    cnt++;
                }
            }
            result[i] = (char) ((j % 26) + 'a');
        }
        return String.valueOf(result);
    }
}