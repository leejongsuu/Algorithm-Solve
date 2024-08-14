class Solution {
    public String solution(String phone_number) {
        
        StringBuilder sb = new StringBuilder();
        
        int len = phone_number.length();
        
        for(int i = 0; i < len; i++) {
            if(len - i > 4) {
                sb.append("*");
            } else {
                sb.append(phone_number.charAt(i));
            }
        }
        
        return sb.toString();
    }
}