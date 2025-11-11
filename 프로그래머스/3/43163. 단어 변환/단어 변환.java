import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(begin);
        visited.add(begin);
        
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                if(current.equals(target)) {
                    return count;
                }
                
                for(String word : words) {
                    if(visited.contains(word)) {
                        continue;
                    }
                    
                    if(oneDiffCheck(current, word)) {
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            count++;
        }
        
        return 0;
    }
    
    public boolean oneDiffCheck(String a, String b) {
        int len = a.length();
        
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
                if(count > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}