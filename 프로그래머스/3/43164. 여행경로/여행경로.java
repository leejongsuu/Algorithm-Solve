import java.util.*;

class Solution {
    private Map<String, PriorityQueue<String>> flights;
    private List<String> itinerary;

    public String[] solution(String[][] tickets) {
        flights = new HashMap<>();
        itinerary = new ArrayList<>();

        // 티켓 정보를 Map에 저장
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).offer(ticket[1]);
        }

        // DFS를 통해 경로 구하기
        dfs("ICN");

        // List를 배열로 변환하여 반환
        return itinerary.toArray(new String[itinerary.size()]);
    }

    private void dfs(String airport) {
        // 출발 공항에서 도착 공항으로 이동하는 티켓이 있는지 확인
        PriorityQueue<String> destinations = flights.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll());
        }

        // 경로 추가
        itinerary.add(0, airport);
    }
}
