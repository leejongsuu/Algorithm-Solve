import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> termMap = new HashMap<>();
        for(String str : terms) {
            String[] splited = str.split(" ");
            termMap.put(splited[0], Integer.parseInt(splited[1]) * 28);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        int todayInt = CalculateDate(today);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] splited = privacies[i].split(" ");
            if(todayInt >= CalculateDate(splited[0]) + termMap.get(splited[1])) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int CalculateDate(String str) {
        String[] splited = str.split("[.]");
        
        int sum = 0;
        sum += Integer.parseInt(splited[0]) * 12 * 28;
        sum += Integer.parseInt(splited[1]) * 28;
        sum += Integer.parseInt(splited[2]);
        
        return sum;
    }
}