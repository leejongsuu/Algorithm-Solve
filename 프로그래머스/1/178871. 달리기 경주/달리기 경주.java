import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            indexMap.put(players[i], i);
        }
        
        for(String call : callings) {
	        int idx = indexMap.get(call);
            players[idx] = players[idx - 1];
            players[idx - 1] = call;
            indexMap.put(players[idx - 1], idx - 1);
            indexMap.put(players[idx], idx);
        }
        
        return players;
    }
}