import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for(String term : terms) {
            String[] splited = term.split(" ");
            termsMap.put(splited[0].charAt(0), Integer.valueOf(splited[1]) * 28);
        }
        
        int INF = calculateDate(today);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] splited = privacies[i].split(" ");
            
            if(INF >= calculateDate(splited[0]) + termsMap.get(splited[1].charAt(0))) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int calculateDate(String str) {
        String[] date = str.split("[.]");
        
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        
        return (year * 28 * 12) + (month * 28) + day;
    }
}