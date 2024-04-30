import java.util.*;

class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length -1; i++) {
            char max = ch[i];
            int index = i;
            for(int j = i + 1; j < ch.length; j++) {
                if(ch[j] - '0' > max - '0') {
                    max = ch[j];
                    index = j;
                }
            }
            swap(ch, i, index);
        }
        
        return String.valueOf(ch);
    }
    
    static void swap(char[] ch, int p, int q) {
        char temp = ch[p];
        ch[p] = ch[q];
        ch[q] = temp;
    }
}