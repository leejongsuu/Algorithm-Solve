import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        };
        
        String[] strArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strArr, comp);
        
        StringBuilder sb = new StringBuilder();
        for(String str : strArr) {
            sb.append(str);
        }
        
        answer = sb.toString();
        
        if(answer.charAt(0)=='0') {
            return "0";
        }
        
        return answer;
    }
}