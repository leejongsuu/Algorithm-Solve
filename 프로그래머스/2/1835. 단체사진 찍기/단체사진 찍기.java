import java.util.*;

class Solution {
    
    final int INF = 8;
    final char[] ch = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    int result = 0;
    boolean[] visited = new boolean[INF];
    String[] data;
    
    public int solution(int n, String[] data) {
        this.data = data;
        dfs(0, new char[INF]);
        return result;
    }
    
    void dfs(int L, char[] temp) {
        if(L == INF) {
            String str = String.valueOf(temp.clone());
            if(validate(str)) result++;
            return;
        }
        
        for(int i = 0; i < INF; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[L] = ch[i];
                dfs(L + 1, temp);
                visited[i] = false;
            }
        }
    }
    
    boolean validate(String str) {
        for(String d : data) {
            String a = String.valueOf(d.charAt(0));
            String b = String.valueOf(d.charAt(2));
            char c = d.charAt(3);
            int n = d.charAt(4) - '0';
            
            int dis = Math.abs(str.indexOf(a) - str.indexOf(b)) - 1;
            if(!operand(c, dis, n)) return false;
        }
        
        return true;
    }
    
    boolean operand(char c, int dis, int standard) {
        return switch (c) {
            case '=' -> dis == standard;
            case '>' -> dis >  standard;
            case '<' -> dis <  standard;
            default  -> false;
        };
    }
}