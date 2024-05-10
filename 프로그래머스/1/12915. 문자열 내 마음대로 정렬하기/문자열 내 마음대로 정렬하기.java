import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String a, String b) {
                if(a.charAt(n) == b.charAt(n)) return a.compareTo(b);
                else return a.charAt(n) - b.charAt(n);
            }
        };
        
        Arrays.sort(strings, comp);
        return strings;
    }
}