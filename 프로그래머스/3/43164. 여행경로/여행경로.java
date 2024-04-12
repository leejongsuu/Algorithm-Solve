import java.util.*;

class Solution {
    
    private Map<String, PriorityQueue<String>> flights;
    private List<String> list;
    
    public String[] solution(String[][] tickets) {
        flights = new HashMap<>();
        list = new ArrayList<>();
        
        for(String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
            flights.get(ticket[0]).offer(ticket[1]);
        }
        
        dfs("ICN");
        
        return list.toArray(new String[list.size()]);
    }
    
    private void dfs(String airport) {
        
        PriorityQueue<String> destination = flights.get(airport);
        while(destination != null && !destination.isEmpty()) {
            dfs(destination.poll());
        }
        
        list.add(0, airport);
    }
}