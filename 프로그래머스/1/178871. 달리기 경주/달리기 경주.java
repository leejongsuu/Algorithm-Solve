import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> rankMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for(String call : callings) {
            int post = rankMap.get(call);
            int pre = rankMap.get(players[post - 1]);
            rankMap.put(call, pre);
            rankMap.put(players[post-1], post);
            players[post] = players[pre];
            players[pre] = call;
        }
        
        return players;
    }
    
}