import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;

        List<Integer> candidates = new ArrayList<>();
        
        for(int subset = 1; subset < (1 << m); subset++) {
            
            if(!isMinimal(subset, candidates)) {
                continue;
            }
            
            if(isUnique(subset, relation, n, m)) {
                candidates.add(subset);
            }
        }
        
        return candidates.size();
    }
    
    boolean isMinimal(int subset, List<Integer> candidates) {
        for(int candidate : candidates) {
            if((subset &  candidate) == candidate) {
                return false;
            }
        }
        return true;
    }
    
    boolean isUnique(int subset, String[][] relation, int n, int m) {
        Set<String> seen = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++) {
                if((subset & (1 << j)) != 0) {
                    sb.append(relation[i][j]);
                }
            }
            String key = sb.toString();
            if(!seen.add(key)) {
                return false;
            }
        }
        return true;
    }
}