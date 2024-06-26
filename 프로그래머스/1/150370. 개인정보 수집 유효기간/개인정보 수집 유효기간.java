import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> termMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int date = calculateDate(today);
        
        for(String term : terms) {
            String[] splited = term.split(" ");
            termMap.put(splited[0], Integer.parseInt(splited[1]) * 28);
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] splited = privacies[i].split(" ");
            if(date >= calculateDate(splited[0]) + termMap.get(splited[1])) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int calculateDate(String str) {
        String[] splited = str.split("[.]");
        
        int year = Integer.parseInt(splited[0]);
        int month = Integer.parseInt(splited[1]);
        int day = Integer.parseInt(splited[2]);
        
        return (year * 28 * 12) + (month * 28) + day;
    }
}