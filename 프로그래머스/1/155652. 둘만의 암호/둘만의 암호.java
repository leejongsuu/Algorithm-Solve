class Solution {
    public String solution(String s, String skip, int index) {
        
        boolean[] flag = new boolean[26];
        for(char c : skip.toCharArray()) {
            flag[c - 'a'] = true;
        }
        
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            int asc = ch[i] - 'a';
            for(int j = 0; j < index; j++) {
                while(true) {
                    asc++;
                    if(asc >  25) asc = 0;
                    if(!flag[asc]) {
                        break;
                    }    
                }
            }
            ch[i] = (char) (asc + (int) 'a');
        }
        //a b c d e f g h i j k l m n o p q r s t u v w x y z
        return String.valueOf(ch);
    }
}