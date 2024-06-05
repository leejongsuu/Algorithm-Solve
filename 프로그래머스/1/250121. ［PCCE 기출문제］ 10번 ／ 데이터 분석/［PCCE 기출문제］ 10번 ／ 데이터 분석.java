import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // 열 인덱스 매핑
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        // ext와 sort_by에 해당하는 열 인덱스
        int extIndex = map.get(ext);
        int sortByIndex = map.get(sort_by);
        
        // 스트림을 사용하여 필터링 및 정렬
        List<int[]> filteredAndSortedData = Arrays.stream(data)
            .filter(row -> row[extIndex] < val_ext) // ext 기준으로 필터링
            .sorted(Comparator.comparingInt(row -> row[sortByIndex])) // sort_by 기준으로 정렬
            .collect(Collectors.toList());
        
        // 리스트를 배열로 변환
        int[][] result = new int[filteredAndSortedData.size()][];
        for (int i = 0; i < filteredAndSortedData.size(); i++) {
            result[i] = filteredAndSortedData.get(i);
        }
        
        return result;
    }
}
