import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> personMap = new HashMap<>();
        for(String person : participant) {
            personMap.put(person, personMap.getOrDefault(person, 0) + 1);
        }
        
        for(String person : completion) {
            personMap.put(person, personMap.get(person) - 1);
        }
        
        for(String person : personMap.keySet()) {
            if(personMap.get(person) > 0) {
                return person;
            }
        }
        
        return "전부 완주";
    }
}
