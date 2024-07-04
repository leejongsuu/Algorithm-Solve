import java.util.HashMap;

class Solution {
    
    public String solution(String[] seoul) {
        
        HashMap<String, Integer> posMap = new HashMap<>();
        for(int i = 0; i < seoul.length; i++) {
            posMap.put(seoul[i], i);
        }
        
        return "김서방은 " + posMap.get("Kim") + "에 있다";
    }
}