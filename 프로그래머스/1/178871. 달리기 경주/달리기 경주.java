import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> playerMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for(String player : callings) {
            int index = playerMap.get(player);
            
            if(index == 0) continue;
            
            String frontPlayer = players[index - 1];
            players[index -1] = player;
            players[index] = frontPlayer;
            
            playerMap.put(frontPlayer, index);
            playerMap.put(player, index - 1);
        }
        
        return players;
    }
}