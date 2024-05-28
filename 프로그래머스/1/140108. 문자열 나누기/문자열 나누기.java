class Solution {
    public int solution(String s) {
        int result = 0;
        int i = 0;
        int len = s.length();
        while(i < len) {
            char c = s.charAt(i++);
            int lt = 1;
            int rt = 0;
            
            while(rt != lt) {
                if(i == len) break;
                if(s.charAt(i) == c) {
                    lt++;
                } else {
                    rt++;
                }
                i++;
            }
            result++;
            s = s.substring(i);
            len = s.length();
            i = 0;
        }
        
        return result;
    }
}