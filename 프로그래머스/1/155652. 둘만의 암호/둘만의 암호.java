class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] skipSet = new boolean[26];
        for (char ch : skip.toCharArray()) {
            skipSet[ch - 'a'] = true;
        }

        int len = s.length();
        char[] result = new char[len];
        
        for (int i = 0; i < len; i++) {
            char word = s.charAt(i);
            int cnt = 0;
            int j = word - 'a';
            while (cnt < index) {
                j = (j + 1) % 26;
                if (!skipSet[j]) {
                    cnt++;
                }
            }
            result[i] = (char) (j + 'a');
        }
        
        return new String(result);
    }
}