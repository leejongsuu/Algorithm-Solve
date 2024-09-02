import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                char a = o1.charAt(n);
                char b = o2.charAt(n);
                if(a == b) return o1.compareTo(o2);
                else return a - b;
            }
        };
        
        Arrays.sort(strings, comp);
        
        return strings;
    }
}