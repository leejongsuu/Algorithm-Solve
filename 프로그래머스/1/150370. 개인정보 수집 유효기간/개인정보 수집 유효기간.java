import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        int INF = getDays(today);
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] splited = term.split(" ");
            map.put(splited[0].charAt(0), Integer.parseInt(splited[1]) * 28);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            String[] splited = privacies[i].split(" ");
            
            int sum = getDays(splited[0]) + map.get(splited[1].charAt(0));
            if(INF >= sum) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    private int getDays(String date) {
        String[] splited = date.split("[.]");
        
        int year = Integer.parseInt(splited[0]) - 1;
        int month = Integer.parseInt(splited[1]) - 1;
        int day = Integer.parseInt(splited[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}