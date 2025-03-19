import java.util.*;

class Solution {
    
    Map<String, List<Integer>> infoMap = new HashMap<>();
    final int INF = 4;
    public int[] solution(String[] info, String[] query) {
        
        int len = query.length;
        int[] result = new int[len];
        
        for(String applicant : info) {
            String[] parts = applicant.split(" ");
            makeInfoMap(0, "", parts, Integer.parseInt(parts[INF]));
        }
        
        for(String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        for(int i = 0; i < len; i++) {
            String[] parts = query[i].replaceAll(" and ", "").split(" ");
            String key = parts[0];
            int score = Integer.parseInt(parts[1]);
            
            if(infoMap.containsKey(key)) {
                int index = binarySearch(score, infoMap.get(key));
                result[i] = infoMap.get(key).size() - index;
            }
        }
        
        return result;
    }
    
    public void makeInfoMap(int L, String str, String[] parts, int score) {
        if(L == INF) {
            infoMap.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        }
        
        makeInfoMap(L + 1, str + parts[L], parts, score);
        makeInfoMap(L + 1, str + "-", parts, score);
    }
    
    public int binarySearch(int score, List<Integer> scoreList) {
        int lo = 0;
        int hi = scoreList.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(scoreList.get(mid) < score) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}