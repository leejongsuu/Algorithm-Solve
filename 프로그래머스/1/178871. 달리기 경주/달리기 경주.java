import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            indexMap.put(players[i], i);
        }
        
        for(String call : callings) {
            int index = indexMap.get(call);
            
            players[index] = players[index - 1];
            players[index - 1] = call;
            
            indexMap.put(players[index], index);
            indexMap.put(players[index - 1], index - 1);
        }
        
        return players;
    }
}