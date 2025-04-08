import java.util.*;

class Solution {
    
    char[] ch = new char[16];
    
    public String solution(int n, int t, int m, int p) {
        for(int i = 0; i < 10; i++) {
            ch[i] = (char) (i + '0');
        }
        for(int i = 0; i < 6; i++) {
            ch[i + 10] = (char) ('A' + i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= m; i++) {
            queue.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int num = 0; t > 0; num++) {
            String sNum = toScale(num, n);
            for(int i = 0; i < sNum.length() && t > 0; i++) {
                int current = queue.poll();
                if(current == p) {
                    t--;
                    sb.append(sNum.charAt(i));
                }
                queue.offer(current);
            }
        }
        
        return sb.toString();
    }
    
    public String toScale(int num, int n) {
        if(num == 0) return "0";
        else {
            StringBuilder sb = new StringBuilder();
            while(num > 0) {
                int value = num % n;
                sb.insert(0, ch[value]);
                num /= n;
            }
            return sb.toString();
        }
    }
}