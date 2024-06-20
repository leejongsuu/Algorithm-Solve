import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        char[][] personality = new char[][]{{'R','T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        HashMap<Character, Integer> map = new HashMap<>();
        for(char[] ch : personality) {
            map.put(ch[0], 0);
            map.put(ch[1], 0);
        }
        
        int len = choices.length;
        for(int i = 0; i < len; i++) {
            String str = survey[i];
            int value = 0;
            if(choices[i] < 4) {
                value = 4 - choices[i];
                map.put(str.charAt(0), map.get(str.charAt(0))+value);
            } else if(choices[i] > 4) {
                value = choices[i] - 4;
                map.put(str.charAt(1), map.get(str.charAt(1))+value);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char[] ch : personality) {
            sb.append(map.get(ch[0]) >= map.get(ch[1]) ? ch[0] : ch[1]);
        }
        
        
        return sb.toString();
    }
}