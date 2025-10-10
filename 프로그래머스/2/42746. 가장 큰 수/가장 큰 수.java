import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        int len = numbers.length;
        
        String[] sNumbers = new String[len];
        for(int i = 0; i < len; i++) {
            sNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(sNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        if(sNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(sNumbers[i]);
        }
        
        return sb.toString();
    }
}