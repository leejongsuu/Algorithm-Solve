import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        HashMap<String, Integer> memoryMap = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            memoryMap.put(name[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                String key = photo[i][j];
                if(memoryMap.containsKey(key)) {
                    sum += memoryMap.get(key);
                }
            }
            result[i] = sum;
        }
        return result;
    }
}