import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] result = new int[id_list.length];
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }
        
        
        for(String str : report) {
            String[] splited = str.split(" ");
            String to = splited[0];
            String from = splited[1];
            
            reportMap.get(from).add(to);
        }
        
        for(String id : id_list) {
            if(reportMap.get(id).size() >= k) {
                for(String name : reportMap.get(id)) {
                    result[indexMap.get(name)]++;
                }
            }
        }
        
        return result;
    }
}
