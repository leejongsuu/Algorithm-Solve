import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String> Q = new LinkedList<>();
        Q.offer(begin);
        
        int level = 0;
        while(!Q.isEmpty()) {
            
            int size = Q.size();
            for(int i=0; i<size; i++) {
                String current = Q.poll();
                if(current.equals(target)) {
                    return level;
                }
                
                for(int j=0; j<words.length; j++) {
                    if(check(current, words[j]) && !visited[j]) {
                        visited[j] = true;
                        Q.offer(words[j]);
                    }
                }
            }
            
            level++;
        }
        return answer;
    }
    
    public boolean check(String a, String b) {
        int diffCount = 0;
        
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
            if(diffCount > 1) return false;
        }
        
        return diffCount == 1;
    }
}