class Solution {
    public int solution(String s) {
        int result = Integer.MAX_VALUE;
        int len = s.length();
        
        if(len == 1) return 1; // 예외 처리
        
        for(int i = 1; i <= (len / 2); i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String current = s.substring(0, i);
            
            for(int j = i; j <= len; j+=i) {
                int tempLength = Math.min(j + i, len);
                String next = s.substring(j, tempLength);
                
                if(current.equals(next)) {
                    count++;
                } else {
                    sb.append(count > 1 ? count + current : current);
                    current = next;
                    count = 1;
                }
            }
            sb.append(count > 1 ? count + current : current);
            result = Math.min(result, sb.length());
        }
        
        return result;
    }
}