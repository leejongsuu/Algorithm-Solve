import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int useage = 0;
        
        while(n > 0) {
            if(n % 2 != 0) {
                useage++;
            } 
            n /= 2;
        }
        
        return useage;
    }
}