import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                
                char word = key.charAt(i);
                
                if(!map.containsKey(word)) {
                    map.put(word, i + 1);
                } else {
                    int origin = map.get(word);
                    if(i + 1 < origin) {
                        map.put(word, i + 1);
                    }
                }
            }
        }
        
        int[] result = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            int count = 0;
            for(char word : targets[i].toCharArray()) {
                Integer sequence = map.get(word);
                if(sequence == null) {
                    count = -1;
                    break;
                } else {
                    count += sequence;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}
