import java.util.*;

class Solution {
    public int solution(String s) {
        
        List<Integer> resultList = new ArrayList<>();
        
        int size = s.length();
        
        for(int len = 1; len <= size / 2; len++) {
            StringBuilder sb = new StringBuilder();
            
            int count = 1;
            String before = s.substring(0, len);
            
            for(int i = len; i <= size; i += len) {
                String current = s.substring(i, Math.min(i + len, size));
                
                if(!current.equals(before)) {
                    if(count > 1) {
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(before);
                    before = current;
                } else {
                    count++;
                }
            }
            if(count > 1) {
                sb.append(count);
                count = 1;
            }
            sb.append(before);
            
            resultList.add(sb.length());
        }
        
        Collections.sort(resultList);
        
        return resultList.isEmpty() ? 1 : resultList.get(0);
    }
}