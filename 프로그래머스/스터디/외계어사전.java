import java.util.TreeSet;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        TreeSet<Character> set = new TreeSet<>();
        for(String str : spell) {
            set.add(str.charAt(0));
        }
        
        int len = spell.length;
        for(String str : dic) {
            char[] alphabet = new char[26];
            int cnt = 0;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(!set.contains(c) || alphabet[c-'a'] > 0) break;
                else {
                    alphabet[c-'a']++;
                    cnt++;
                }
            }
            if(cnt == len) return 1;
        }
        return 2;
    }
}
