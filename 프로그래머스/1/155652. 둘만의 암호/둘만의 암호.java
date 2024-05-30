class Solution {
    public String solution(String s, String skip, int index) {
        
        boolean[] visited = new boolean[26];
        for(int i = 0; i < skip.length(); i++) {
            visited[skip.charAt(i) - 'a'] = true;
        }
        
        char[] result = s.toCharArray();
        for(int i = 0; i < result.length; i++) {
            
            int j = result[i] - 'a';
            int cnt = 0;
            while(cnt < index) {
                if(visited[++j % 26]) continue;
                cnt++;
            }
            j %= 26;
            result[i] = (char) (j + 'a');
        }
        
        return new String(result);
    
    }
}