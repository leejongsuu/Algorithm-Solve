import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        // init
        for(String id : id_list) {
            reportMap.put(id, new HashSet<>());
            countMap.put(id, 0);
        }
        
        for(String str : report) {
            String[] splited = str.split(" ");
            HashSet<String> idSet = reportMap.get(splited[0]);
            if(!idSet.contains(splited[1])) {
                idSet.add(splited[1]);
                countMap.put(splited[1], countMap.get(splited[1]) + 1);    
            }
        }
        
        int len = id_list.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            for(String id : reportMap.get(id_list[i])) {
                if(countMap.get(id) >= k) answer[i]++;
            }
        }
        
        return answer;
    }
}