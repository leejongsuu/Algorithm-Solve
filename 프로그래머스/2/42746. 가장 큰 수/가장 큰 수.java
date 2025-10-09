import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        int len = numbers.length;
        
        String[] strNumbers = new String[len];
        
        for(int i = 0; i < len; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        if(strNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String strNumber : strNumbers) {
            sb.append(strNumber);
        }
        
        return sb.toString();
    }
}