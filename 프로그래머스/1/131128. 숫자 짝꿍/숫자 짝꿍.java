import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String solution(String X, String Y) {
        
        final int INF = 10;
        int[] checkX = new int[INF];
        int[] checkY = new int[INF];
        
        for(char x : X.toCharArray()) checkX[x - '0']++;
        for(char y : Y.toCharArray()) checkY[y - '0']++;
        
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < INF; i++) {
            while(checkX[i] > 0 && checkY[i] > 0) {
                checkX[i]--;
                checkY[i]--;
                list.add(String.valueOf(i));
            }
        }
    
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        String answer = "";
        if(list.isEmpty()) answer = "-1";
        else if(list.get(0).equals("0")) answer = "0";
        else {
            StringBuilder sb = new StringBuilder();
            for(String s : list) sb.append(s);
            answer = sb.toString();
        }
        
        return answer;
    }
}