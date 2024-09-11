import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        indexMap.put("code", 0);
        indexMap.put("date", 1);
        indexMap.put("maximum", 2);
        indexMap.put("remain", 3);
        
        int extIndex = indexMap.get(ext);
        int sortIndex = indexMap.get(sort_by);
        
        return Arrays.stream(data)
                    .filter(row -> row[extIndex] < val_ext)
                    .sorted(Comparator.comparingInt(row -> row[sortIndex]))
                    .toArray(int[][]::new);
        
        
    }
}