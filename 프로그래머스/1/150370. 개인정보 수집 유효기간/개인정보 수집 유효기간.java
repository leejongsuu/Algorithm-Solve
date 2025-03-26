import java.util.*;

class Solution {
    final int days = 28;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], days * Integer.parseInt(parts[1]));
        }
        
        int iToday = getIntPrivacy(today);
        List<Integer> resultList = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int privacy = getIntPrivacy(parts[0]);
            privacy += termMap.get(parts[1]);
            if(iToday >= privacy) {
                resultList.add(i + 1);
            }
        }
        
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int getIntPrivacy(String privacy) {
        int day = 0;
        
        String[] part = privacy.split("[.]");
        
        day += 12 * days * Integer.parseInt(part[0]);
        day += days * Integer.parseInt(part[1]);
        day += Integer.parseInt(part[2]);
        
        return day;
    }
}