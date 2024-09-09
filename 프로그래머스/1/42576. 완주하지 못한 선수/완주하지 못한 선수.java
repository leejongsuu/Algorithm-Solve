import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> personNameMap = new HashMap<>();
        for(String name : participant) {
            personNameMap.put(name, personNameMap.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            personNameMap.put(name, personNameMap.get(name) - 1);
        }
        
        for(String name : personNameMap.keySet()) {
            if(personNameMap.get(name) > 0) {
                return name;
            }
        }
        
        return "없음";
    }
}