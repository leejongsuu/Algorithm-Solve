import java.util.HashMap;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        
        HashMap<Character, Integer> keyCountMap = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char key = keymap[i].charAt(j);
                if(!keyCountMap.containsKey(key)) {
                    keyCountMap.put(key, j + 1);
                } else {
                    keyCountMap.put(key, Math.min(j + 1, keyCountMap.get(key)));    
                }
            }
        }
        
        int len = targets.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = getClickCount(keyCountMap, targets[i]);
        }
        
        return result;
    }
    
    private int getClickCount(HashMap<Character, Integer> keyCountMap, String target) {
        
        int count = 0;
        
        for(char key : target.toCharArray()) {
            if(!keyCountMap.containsKey(key)) {
                return -1;
            }
            
            count += keyCountMap.get(key);
        }
        
        return count;
    }
    
}