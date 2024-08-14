class Solution {
    public String solution(String s) {
        int len = s.length();
        int half = len / 2;
        if(len % 2 == 0) {
            return String.valueOf(s.charAt(half - 1)) + String.valueOf(s.charAt(half));
        } else {
            return String.valueOf(s.charAt(half));
        }
    }
}