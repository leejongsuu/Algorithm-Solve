class Solution {
    public int solution(String s) {
        
        int len = s.length();
        int result = s.length();
        
        for(int i = 1; i <= len / 2; i++) {
            StringBuffer sb = new StringBuffer();
            String before = s.substring(0, i);
            int count = 1;
            
            for(int j = i; j < len; j += i) {
                String current = s.substring(j, Math.min(j + i, len));
                if(current.equals(before)) {
                    count++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(before);
                    before = current;
                }
            }
            if(count > 1) {
                sb.append(count);
                count = 1;
            }
            sb.append(before);
            result = Math.min(result, sb.length());
        }
        
        return result;
    }
}