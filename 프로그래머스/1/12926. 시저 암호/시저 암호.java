class Solution {
    
    private static final int lower = (int) 'z';
    private static final int upper = (int) 'Z';
    
    public String solution(String s, int n) {
        
        int len = s.length();
        
        char[] result = new char[len];
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                result[i] = c;
            } else if((int) c <= upper) {
                result[i] = getEncryption(c, n, upper);
            } else {
                result[i] = getEncryption(c, n, lower);
            }
        }
        return String.valueOf(result);
    }
    
    private char getEncryption(char c, int n, int boundary) {
        int value = (int) c + n;
        if(value > boundary) {
            value -= 26;
        }
        return (char) value;        
    }
}