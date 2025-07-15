class Solution {
    
    public String solution(int n, int t, int m, int p) {
        char[] ch = new char[16];
        for(int i = 0; i < 10; i++) ch[i] = (char) ('0' + i);
        for(int i = 0; i < 6; i++) ch[i + 10] = (char) ('A' + i);
        
        StringBuilder sb = new StringBuilder();
        
        int num = 0, sequence = 0;
        while(sb.length() < t) {
            String scale = toScale(n, num, ch);
            for(char s : scale.toCharArray()) {
                if(sequence % m == p - 1) {
                    sb.append(s);
                    if(sb.length() == t) break;
                }
                sequence++;
            }
            num++;
        }
        
        return sb.toString();
    }
    
    String toScale(int n, int num, char[] ch) {
        if(num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            sb.insert(0, ch[num % n]);
            num /= n;
        }
        
        return sb.toString();
    }
}