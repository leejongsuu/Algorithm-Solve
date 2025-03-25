import java.util.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("code", 0);
        dataMap.put("date", 1);
        dataMap.put("maximum", 2);
        dataMap.put("remain", 3);
        
        int extIndex = dataMap.get(ext);
        int sortByIndex = dataMap.get(sort_by);
        
        return Arrays.stream(data)
            .filter(row -> row[extIndex] < val_ext)
            .sorted(Comparator.comparingInt(row -> row[sortByIndex]))
            .toArray(int[][]::new);
    }
}