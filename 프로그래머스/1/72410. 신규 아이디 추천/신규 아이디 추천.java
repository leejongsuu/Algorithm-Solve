class Solution {
    public String solution(String new_id) {
        // 1단계, 2단계, 3단계
        new_id = new_id.toLowerCase()
            .replaceAll("[^a-z0-9-_.]","").replaceAll("\\.{2,}",".");
        
        // 4단계
        StringBuilder sb = new StringBuilder(new_id);
        if(sb.charAt(0) =='.') sb.delete(0, 1);
        int len = sb.length();
        if(len != 0 && sb.charAt(len - 1) =='.') sb.delete(len -1 , len);
        
        len = sb.length();
        if(len == 0) sb.append('a'); // 5단계
        else if(len > 15) {
            sb.delete(15, len); // 6단계
            if(sb.charAt(14) =='.') sb.delete(14, 15);
        }
        len = sb.length();
        char e = sb.charAt(len - 1);
        while(len < 3) {
            sb.append(e);
            len++;
        }
        
        return sb.toString();
    }
}