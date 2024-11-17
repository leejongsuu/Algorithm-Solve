import java.util.*;

class Solution {
    
    static int index = 1;
    static final int INF = 5;
    static Map<String, Integer> map = new HashMap<>();
    static char[] ch = new char[]{'A', 'E', 'I', 'O', 'U'};
    static StringBuilder sb = new StringBuilder();
    
    public int solution(String word) {
        
        DFS(0);
        
        return map.get(word);
    }
    
    private void DFS(int L) {
        if(L == INF) {
            return;
        }
        
        for(int i = 0; i < INF; i++) {
            sb.append(ch[i]);
            map.put(sb.toString(), index++);
            DFS(L + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}