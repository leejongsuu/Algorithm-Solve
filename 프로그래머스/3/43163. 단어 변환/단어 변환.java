import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];

        Queue<String> Q = new LinkedList<>();
        Q.offer(begin);
        
        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                String current = Q.poll();
                if(current.equals(target)) {
                    return level;
                }
            
                for(int j=0; j<words.length; j++) {
                    int cnt = 0;
                    String word = words[j];
                    
                    for(int k=0; k<word.length(); k++) {
                        if(current.charAt(k) != word.charAt(k)) {
                            cnt++;
                        }
                        if(cnt > 1) break;
                    }
                    
                    if(cnt == 1 && !visited[j]) {
                        visited[j] = true;
                        Q.offer(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}