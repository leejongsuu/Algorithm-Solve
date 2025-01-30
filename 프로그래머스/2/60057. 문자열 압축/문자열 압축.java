class Solution {
    public int solution(String s) {
        int result = Integer.MAX_VALUE;
        
        int len = s.length();
        if(len == 1) return 1;
        
        for(int i = 1; i <= (len / 2); i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String current = s.substring(0, i);
            for(int j = i; j < len; j+= i) {
                int tempLength = Math.min(len, j + i);
                String next = s.substring(j, tempLength);
                if(current.equals(next)) {
                    count++;
                } else {
                    if(count == 1) {
                        sb.append(current);
                    } else {
                        sb.append(count).append(current);
                    }
                    current = next;
                    count = 1;
                }
            }
            if(count == 1) {
                sb.append(current);
            } else {
                sb.append(count).append(current);
            }
            
            result = Math.min(result, sb.length());
        }
        
        return result;
    }
}