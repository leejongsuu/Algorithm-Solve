import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];

        Queue<char[]> Q = new LinkedList<>();
        Q.offer(begin.toCharArray());
        
        char[] targetArr = target.toCharArray();
        
        int level = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                char[] current = Q.poll();
                if(Arrays.equals(current, targetArr)) {
                    return level -1;
                }
            
                for(int j=0; j<words.length; j++) {
                    int cnt = 0;
                    int index = 0;
                    String word = words[j];
                    for(int k=0; k<word.length(); k++) {
                        if(current[k] != word.charAt(k)) {
                            cnt++;
                            index = k;
                        }
                        if(cnt > 1) break;
                    }
                    if(cnt == 1 && !visited[j]) {
                        visited[j] = true;
                        Q.offer(word.toCharArray());
                    }
                }
            }
            level++;
        }
        return 0;
    }
}