import java.util.*;

class Solution {
    
    Map<String, List<Integer>> infoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {

        // 1. 조합 생성
        for(String s : info) {
            String[] parts = s.split(" ");
            int score = Integer.parseInt(parts[4]);
            generateCombinations(0, "", parts, score);   
        }
        
        // 2. 이분 탐색 위한 정렬
        for(List<Integer> scoreList : infoMap.values()) {
            Collections.sort(scoreList);
        }
        
        int len = query.length;
        int[] result = new int[len];
        
        // 3. 쿼리 탐색
        for(int i = 0; i < len; i++) {
            String[] parts = query[i].replace(" and ", "").split(" ");
            String key = parts[0];
            int targetScore = Integer.parseInt(parts[1]);
            
            if(infoMap.containsKey(key)) {
                List<Integer> scoreList = infoMap.get(key);
                result[i] = lowerBoundBinarySearch(targetScore, scoreList);
            }
        }
        
        return result;
    }
    
    
    public void generateCombinations(int depth, String current, String[] parts, int score) {
        if(depth == 4) {
            infoMap.computeIfAbsent(current, k -> new ArrayList<>()).add(score); 
            return;
        }
        
        generateCombinations(depth + 1, current + parts[depth], parts, score);
        generateCombinations(depth + 1, current + "-", parts, score);
    }
    
    public int lowerBoundBinarySearch(int target, List<Integer> scoreList) {

        int lt = 0;
        int rt = scoreList.size();
        
        while(lt < rt) {
            int mid = (lt + rt) / 2;
            if(scoreList.get(mid) < target) {
                lt = mid +1;
            } else {
                rt = mid;
            }
        }
        
        return scoreList.size() - lt;
    }
}