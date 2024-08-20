class Solution {
    public String solution(String s) {
        
        char[] ch = s.toCharArray();
        
        int len = s.length();
        
        for(int i = 0, j = 0; i < len; i++) {
            
            if(ch[i] == ' ') {
                j = 0;
                continue;  
            } 
            
            int num = (int) ch[i]; 
            if(j % 2 == 0 && num >= (int) 'a' && num <= (int) 'z') {
                num = (num - 'a') + 'A';
            } else if(j % 2 == 1 && num >= (int) 'A' && num <= (int) 'Z') {
                num = (num - 'A') + 'a';
            }
            
            ch[i] = (char) num;
            j++;
        }
        
        return String.valueOf(ch);
    }
}