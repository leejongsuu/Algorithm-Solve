import java.util.*;

class Solution {
    
    private Map<String, PriorityQueue<String>> flights;
    private List<String> itinerary;
    
    public String[] solution(String[][] tickets) {
        
        flights = new HashMap<>();
        itinerary = new ArrayList<>();
        
        for(String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).offer(ticket[1]);
        }
        
        dfs("ICN");
        
        return itinerary.toArray(new String[itinerary.size()]);
    }
    
    public void dfs(String airport) {
        
        PriorityQueue<String> destination = flights.get(airport);
        while(destination!=null && !destination.isEmpty()) {
            dfs(destination.poll());
        }
        
        itinerary.add(0, airport);
    }
}