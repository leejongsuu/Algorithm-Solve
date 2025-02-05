import java.util.*;

class Solution {
    
    Map<String, List<Integer>> infoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        for(String s : info) {
            String[] parts = s.split(" ");
            int score = Integer.parseInt(parts[4]);
            generateCombinations(0, "", parts, score);
        }
        
        for(List<Integer> scores : infoMap.values()) {
            Collections.sort(scores);
        }
        
        int len = query.length;
        int[] result = new int[len];
        
        for(int i = 0; i < len; i++) {
            String[] parts = query[i].replace(" and ", "").split(" ");
            String key = parts[0];
            int score = Integer.parseInt(parts[1]);
            
            if(infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                // int index = Collections.binarySearch(scores, score);
                // if(index < 0) index = - (index + 1);
                // result[i] = scores.size() - index;
                result[i] = binarySearch(key, score);
            }
        }
        
        return result;
    }
    
    // 이분 탐색
    private int binarySearch(String key, int score) {
        List<Integer> list = infoMap.get(key);
        int start = 0, end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
 
        return list.size() - start;
    }
    
    public void generateCombinations(int L , String current, String[] parts, int score) {
        if(L == 4) {
            infoMap.computeIfAbsent(current, k -> new ArrayList<>()).add(score);
            return;
        }
        generateCombinations(L + 1 , current + parts[L], parts, score);
        generateCombinations(L + 1 , current + "-", parts, score);
    }
}