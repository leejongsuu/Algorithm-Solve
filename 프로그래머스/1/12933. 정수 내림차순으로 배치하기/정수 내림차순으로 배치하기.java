import java.util.*;

class Solution {
    public long solution(long n) {
        
        char[] num = String.valueOf(n).toCharArray();
        
        for(int i=0; i<num.length-1; i++) {
            int max = num[i]-'0';
            int index = i;
            for(int j=i+1; j<num.length; j++) {
                if(num[j]-'0' > max) {
                    max = num[j]-'0';
                    index = j;
                }
            }
            char temp = num[i];
            num[i] = num[index];
            num[index] = temp;
        }
        
        return Long.parseLong(String.valueOf(num));
    }
}