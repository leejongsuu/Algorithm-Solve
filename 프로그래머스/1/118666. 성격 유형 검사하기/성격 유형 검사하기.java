import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        HashMap<Character, Integer> personality = new HashMap<>();
        personality.put('R', 0);
        personality.put('T', 0);
        personality.put('C', 0);
        personality.put('F', 0);
        personality.put('J', 0);
        personality.put('M', 0);
        personality.put('A', 0);
        personality.put('N', 0);
        
        int len = choices.length;
        for(int i = 0; i < len; i++) {
            String str = survey[i];
            int value = 0;
            if(choices[i] < 4) {
                value = 4 - choices[i];
                personality.put(str.charAt(0), personality.get(str.charAt(0))+value);
            } else if(choices[i] > 4) {
                value = choices[i] - 4;
                personality.put(str.charAt(1), personality.get(str.charAt(1))+value);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(personality.get('R') >= personality.get('T') ? 'R' : 'T');
        sb.append(personality.get('C') >= personality.get('F') ? 'C' : 'F');
        sb.append(personality.get('J') >= personality.get('M') ? 'J' : 'M');
        sb.append(personality.get('A') >= personality.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}